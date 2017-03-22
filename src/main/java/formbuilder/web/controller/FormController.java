package formbuilder.web.controller;

import java.util.ArrayList;
import java.util.Date;
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

import formbuilder.model.CheckboxItem;
import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.ItemType;
import formbuilder.model.Selection;
import formbuilder.model.TextItem;
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

//	@RequestMapping("/form/view/{id}.html")
//	public String viewForm(@PathVariable Integer id, ModelMap models) {
//		Form form = formDao.getForm(id);
//		models.put("form", form);
//		return "form/view";
//	}

	@RequestMapping(value = "/form/add.html", method = RequestMethod.GET)
	public String addForm(ModelMap models) {
//		models.put("forms", formDao.getForms());
		
		models.put( "form", new Form() );
		models.put( "items", new ArrayList<Item>() );

		return "form/add";
	}

	@RequestMapping(value = "/form/add.html", method = RequestMethod.POST)
	public String addForm(@RequestParam String name, @RequestParam String description, @RequestParam String available) {

		// TODO: instead of creating new, use form object in session scope
		Form form = new Form();
		form.setTitle(name);
		form.setDescription(description);

		int id = 1;	//TODO: REPLACE WITH CURRENT USER FROM SESSION
		form.setAuthor(userDao.getUser(id));

		Date date = new Date();
		form.setCreateDate( date );
		form.setUpdateDate( date );

		// SAVE THE FORM TO DB
		formDao.saveForm(form);

		return "form/add";
	}

	@RequestMapping(value = "/form/edit/{id}.html", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, ModelMap models) {
		Form form = formDao.getForm(id);
		
		models.put( "form", form );
		models.put( "items", form.getItems() );
		
		models.put( "itemTypes", ItemType.values() );
		
		models.put( "newItem", new Item() );
//		models.put( "newTextItem", new TextItem());
//		models.put( "newCheckboxItem", new CheckboxItem());

		return "form/edit";
	}

	@RequestMapping(value = "/form/edit/{id}.html", method = RequestMethod.POST)
	public String edit(@PathVariable Integer id, ModelMap models, @ModelAttribute Form form, BindingResult result, SessionStatus sessionStatus) {

		// TODO: add formValidator here

		form = formDao.saveForm(form);
		models.put( "form", form );
		models.put( "items", form.getItems() );
//		models.put( "newItem", item );
//		sessionStatus.setComplete();

		return "form/edit";
	}
	
	// EDIT EACH QUESTION ITEM BY ID
	@RequestMapping(value = "/form/edit/addQuestion/{id}.html", method = RequestMethod.POST)
	public String editQuestion(@PathVariable Integer id, ModelMap models, @ModelAttribute Form form, @ModelAttribute Item item, BindingResult result, SessionStatus sessionStatus) {
		
		// Create specific subclass Item object and add to 'List<Item> items' inside Form object 
		switch ( item.getItemType() ) {
			case CHECKBOX: 			form.addItem( form.addCheckboxItem() );
									break;
			case DROPDOWN_LIST: 	form.addItem( form.addDropdownListItem() );
									break;
			case MULTIPLE_CHOICE:	form.addItem( form.addMultipleChoiceItem() );
									break;
			case TEXT: 				form.addItem( form.addTextItem() );
									break;
			case TEXT_PARAGRAPH: 	form.addItem( form.addTextParagraphItem() );
									break;
			case DATE: 				form.addItem( form.addDateItem() );
									break;
			case TIME: 				form.addItem( form.addTimeItem() );
									break;
			case IMAGE: 			form.addItem( form.addImageItem() );
									break;
			case PAGE_BREAK: 		form.addItem( form.addPageBreakItem() );
									break;
			case SECTION_HEADER: 	form.addItem( form.addSectionHeaderItem() );
									break;
			default:				break;
		}
		
		form = formDao.saveForm(form);
		models.put( "form", form );
		models.put( "items", form.getItems() );
		
//		sessionStatus.setComplete();

		return "form/edit";
	}
	
	// EDIT EACH SELECTION BY ID
	@RequestMapping(value = "/form/editSelection/{id}.html", method = RequestMethod.POST)
	public String editSelection(@PathVariable Integer id, ModelMap models, @ModelAttribute Form form, BindingResult result, SessionStatus sessionStatus) {


		form = formDao.saveForm(form);
		models.put( "form", form );
		models.put( "items", form.getItems() );
//		sessionStatus.setComplete();

		return "form/edit";
	}
	

	@RequestMapping(value = "/form/remove/{id}.html", method = RequestMethod.GET)
	public String deleteForm(@PathVariable long id) {

		formDao.deleteForm(formDao.getForm(id));

		return "redirect:../list.html";
	}


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