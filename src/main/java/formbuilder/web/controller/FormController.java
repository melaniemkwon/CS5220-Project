package formbuilder.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.Selection;
import formbuilder.model.User;
import formbuilder.model.dao.FormDao;
import formbuilder.model.dao.UserDao;

@Controller
@SessionAttributes({ "forms", "form", "page" })
public class FormController {

	@Autowired
	private FormDao formDao;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/form/list.html")
	public String listForm(ModelMap models) {
		models.put("forms", formDao.getForms());
		return "form/list";
	}

	@RequestMapping("/form/view/{id}.html")
	public String viewForm(@PathVariable Integer id, ModelMap models) {
		Form form = formDao.getForm(id);
		models.put("form", form);
		return "form/view";
	}

	@RequestMapping(value = "/form/add.html", method = RequestMethod.GET)
	public String addForm(ModelMap models) {
		models.put("form", new Form());
		models.put("forms", formDao.getForms());

		return "form/add";
	}

	@RequestMapping(value = "/form/add.html", method = RequestMethod.POST)
	public String addForm(@RequestParam String name, @RequestParam String description, @RequestParam String available) {

		// TODO: instead of creating new, use form object in session scope
		Form form = new Form();
		form.setTitle(name);
		form.setDescription(description);

		if (available.equals("available")) {
			form.setAvailable(true);
		} else {
			form.setAvailable(false);
		}

		/*
		 * ------------------------------------------
		 * 
		 * TODO: for testing before we have user login, this should be replaced
		 * later by userId in the session
		 * 
		 * ------------------------------------------
		 */
		int id = 2;
		form.setAuthor(userDao.getUser(id));

		form.setCreateDate(new java.sql.Date(new java.util.Date().getTime()));

		formDao.saveForm(form);

		// TODO: This should actually be redirecting the the form details page
		// to create the form specifics
		return "redirect:/form/list.html";
	}

//	@RequestMapping(value = "/form/add_page.html", method = RequestMethod.GET)
//	public String addPage(@RequestParam Integer id, ModelMap models) {
//
//		Form form = formDao.getForm(id);
//		// find next page number
//		List<ItemPage> pages = form.getPages();
//		int nextPageNum = pages.size() + 1;
//
//		// create new page and save to db
//		ItemPage page = new ItemPage();
//		page.setForm(form);
////		page.setPageNumber(nextPageNum);
//		formDao.savePage(page);
//
//		models.put("page", page);
//		models.put("form", form);
//
//		return "form/pageview";
//	}

//	@RequestMapping(value = "/form/page_view.html", method = RequestMethod.GET)
//	public String viewPage(@RequestParam Integer id, @RequestParam Integer p, ModelMap models) {
//		Form form = formDao.getForm(id);
//		List<ItemPage> pages = form.getPages();
//		ItemPage page = null;
//		if (p >= 1) {
//			page = pages.get(p);
//		} else {
//			page = pages.get(1);
//		}
//
//		models.put("page", page);
//		models.put("form", form);
//
//		return "form/pageview";
//	}

	@RequestMapping(value = "/form/edit/{id}.html", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap models) {
		models.put("form", formDao.getForm(id));
		// models.put("forms", formDao.getForms());

		return "form/edit";
	}

	@RequestMapping(value = "/form/edit/{id}.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Form form, BindingResult result, SessionStatus sessionStatus) {

		// TODO: add formValidator here
		// if (result.hasErrors() ) return "admin/formEdit";

		form = formDao.saveForm(form);
		sessionStatus.setComplete();

		return "redirect:/form/list.html";
	}

	@RequestMapping(value = "/form/remove/{id}.html", method = RequestMethod.GET)
	public String deleteForm(@PathVariable Integer id) {

		formDao.deleteForm(formDao.getForm(id));

		return "redirect:../list.html";
	}

//	@RequestMapping(value = "/form/add_block.html", method = RequestMethod.GET)
//	public String addBlock(@RequestParam Integer id, @RequestParam Integer p, ModelMap models) {
//		Form form = formDao.getForm(id);
//		List<ItemPage> pages = form.getPages();
//		ItemPage page = null;
//		if (p >= 1) {
//			page = pages.get(p);
//		} else {
//			page = pages.get(1);
//		}
//		models.put("page", page);
//
//		// show form for adding blocks
//
//		return "form/addblock";
//	}
//
//	@RequestMapping(value = "/form/add_block_model.html", method = RequestMethod.POST)
//	public String addBlock(@ModelAttribute ItemBlock block, BindingResult result, SessionStatus sessionStatus,
//			HttpSession session, @RequestParam Integer pid, ModelMap models) {
//
//		ItemPage page = (ItemPage) session.getAttribute("page");
//		block.setPage(page);
//
//		List<ItemBlock> blocks = page.getBlock();
//		block.setIndex(blocks.size());
//
//		block = formDao.saveBlock(block);
//
//		// show page view again
//		return "form/pageview";
//	}
//
//	@RequestMapping(value = "/form/add_block.html", method = RequestMethod.POST)
//	public String addBlock(@RequestParam String name, @RequestParam String description, @RequestParam String available,
//			@RequestParam Integer pid, ModelMap models) {
//
//		ItemBlock block = new ItemBlock();
//		block.setName(name);
//		block.setDescription(description);
//		if (available.equals("avaiable")) {
//			block.setAvailable(true);
//		} else {
//			block.setAvailable(false);
//		}
//
//		ItemPage page = formDao.getPageById(pid);
//		block.setPage(page);
//
//		List<ItemBlock> blocks = page.getBlock();
//		block.setIndex(blocks.size());
//
//		block = formDao.saveBlock(block);
//
//		// show block view
//		models.put("block", block);
//		return "form/blockview";
//	}
//
//	@RequestMapping(value = "/form/block/{id}.html", method = RequestMethod.GET)
//	public String blockView(@PathVariable Integer id, ModelMap models) {
//
//		ItemBlock block = formDao.getBlockById(id);
//		models.put("block", block);
//		return "form/blockview";
//	}
//
//	@RequestMapping(value = "/form/choose_item.html", method = RequestMethod.GET)
//	public String chooseItem(@RequestParam Integer id, ModelMap models) {
//		models.put("id", id);
//
//		return "form/chooseitem";
//	}
//
//	@RequestMapping(value = "/form/choose_item.html", method = RequestMethod.POST)
//	public String chooseItem(@RequestParam Integer id, @RequestParam String itemtype, ModelMap models) {
//		// pass block id
//		models.put("id", id);
//
//		if (itemtype.equals("text")) {
//			return "form/addtextitem";
//		} else {
//			return "form/additem";
//		}
//
//	}
//
//	@RequestMapping(value = "/form/add_item.html", method = RequestMethod.POST)
//	public String addItem(@RequestParam Integer id, @RequestParam Integer total_opt, @RequestParam Integer min,
//			@RequestParam Integer max, @RequestParam String name, @RequestParam String description,
//			@RequestParam String available, @RequestParam String selection_name,
//			@RequestParam String selection_description, ModelMap models) {
//
//		ItemBlock block = formDao.getBlockById(id);
//		ItemSelection item = new ItemSelection();
//
//		// check box with 1 option
//		if (total_opt == 1 && min == 0) {
//			item.setItemType(item.getItemType().CHECKBOX);
//		}
//		// radio button
//		if (total_opt > 1 && max == 1) {
//			item.setItemType(item.getItemType().MULTIPLE_CHOICE);
//		}
//		// checkbox
//		if (total_opt > 1 && total_opt < 10 && max > 1) {
//			item.setItemType(item.getItemType().CHECKBOX);
//		}
//		// pull down
//		if (total_opt > 10 && max == 1) {
//			item.setItemType(item.getItemType().DROPDOWN_LIST);
//		}
//
//		item.setName(name);
//		item.setDescription(description);
//		item.setAvailable(true);
//		item.setRequired(true);
//		// item.setBlock(block);
//		item.setIndex(block.getItems().size());
//		item.setMinRequirements(min);
//		item.setMaxSelectionNum(max);
//
//		item = (ItemSelection) formDao.saveItem(item);
//
//		if (total_opt == 1) {
//			Selection selection_checked = new Selection();
//			selection_checked.setName("SYS_CHECKED");
//			selection_checked.setDescription(description);
//			selection_checked.setValue("1");
//			selection_checked.setOrderId(0);
//			selection_checked.setItem(item);
//
//			Selection selection_unchecked = new Selection();
//			selection_unchecked.setName("SYS_UNCHECKED");
//			selection_unchecked.setDescription(description);
//			selection_unchecked.setValue("0");
//			selection_unchecked.setOrderId(0);
//			selection_unchecked.setItem(item);
//
//			selection_checked = formDao.saveSelection(selection_checked);
//			selection_unchecked = formDao.saveSelection(selection_unchecked);
//		} else {
//			Selection selection = new Selection();
//			selection.setName(selection_name);
//			selection.setDescription(selection_description);
//			selection.setValue(Integer.toString(item.getSelections().size()));
//			selection.setOrderId(item.getSelections().size());
//			selection.setItem(item);
//
//			selection = formDao.saveSelection(selection);
//		}
//
//		models.put("block", block);
//
//		return "form/blockview";
//	}
//
//	@RequestMapping(value = "/form/item/${id}.html", method = RequestMethod.GET)
//	public String viewItem1(@PathVariable Integer id, ModelMap models) {
//
//		Item item = formDao.getItemById(id);
//		models.put("item", item);
//
//		return "form/itemview";
//	}
//
//	@RequestMapping(value = "/form/item.html", method = RequestMethod.GET)
//	public String viewItem(@RequestParam Integer id, ModelMap models) {
//
//		Item item = formDao.getItemById(id);
//		models.put("item", item);
//
//		return "form/itemview";
//	}
}