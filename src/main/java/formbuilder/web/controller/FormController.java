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
@SessionAttributes({ "forms", "form", "selection", "item", "newItem"  })
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
	public String edit1(@PathVariable long id, ModelMap models) {
		
		Form form = formDao.getForm(id);
		models.put( "form", form );
		models.put( "items", form.getItems() );
		
		models.put( "itemTypes", ItemType.values() );
//		models.put( "newItem", new Item() );

		return "form/edit";
	}
	
	@RequestMapping(value = "/form/edit.html", method = RequestMethod.GET)
	public String edit2(@RequestParam long id, ModelMap models) {
		
		Form form = formDao.getForm(id);
		models.put( "form", form );
		models.put( "items", form.getItems() );
		
		models.put( "itemTypes", ItemType.values() );
//		models.put( "newItem", new Item() );

		return "form/edit";
	}

	@RequestMapping(value = "/form/edit/{id}.html", method = RequestMethod.POST)
	public String edit(@PathVariable long id, ModelMap models, @ModelAttribute Form form, BindingResult result, SessionStatus sessionStatus) {

		form = formDao.saveForm(form);
		
		models.put( "form", form );
		models.put( "items", form.getItems() );
		models.put( "itemTypes", ItemType.values() );
//		models.put( "newItem", new Item() );

		return "form/edit";
	}
	
	@RequestMapping(value = "/form/addQuestion/{id}.html", method = RequestMethod.GET)
	public String addQuestion( @PathVariable long id, ModelMap models ) {
		
		// Get the form by ID
		Form form = formDao.getForm(id);
		models.put( "form", form );
		models.put( "itemTypes", ItemType.values() );
		
		// Create new generic item for the form
		Item newItem = new Item();
		newItem.setForm(form);
		models.put( "newItem", newItem );
		
		return "form/addQuestion";
	}
	
	@RequestMapping(value = "/form/addQuestion/{id}.html", method = RequestMethod.POST)
	public String addQuestion(@PathVariable long id, ModelMap models, @ModelAttribute Item newItem, BindingResult result, SessionStatus sessionStatus) {
		
		// Get the form by ID and set it to the Item
		Form form = formDao.getForm(id);
		newItem.setForm(form);
		
		// Convert generic Item to subclass item type, and add to form's list of items
		if ( newItem.getItemType() == ItemType.CHECKBOX ) {
			form.addItem( newItem.asCheckboxItem() );
		} else if ( newItem.getItemType() == ItemType.TEXT ) {
			form.addItem( newItem.asTextItem() );
		}
		
		// Save form to DB
		form = formDao.saveForm( form );
		
		models.put( "form", form );
		models.put( "items", form.getItems() );
		models.put( "itemTypes", ItemType.values() );
		
		// refresh..
		newItem = new Item();
		models.put( "newItem", newItem );
		
		return "redirect:../edit/" + form.getId() + ".html";	
	}
	
	@RequestMapping(value = "/form/deleteQuestion/{id}.html", method = RequestMethod.GET)
	public String deleteQuestion( @PathVariable long id, ModelMap models ) {
		
		Item item = formDao.getItemById(id);
		Form form = formDao.getForm( item.getForm().getId() );
		
		formDao.deleteItem(item);
		
		models.put( "form", form );
		models.put( "items", form.getItems() );
		models.put( "itemTypes", ItemType.values() );
		
		return "redirect:../edit/" + form.getId() + ".html";
	}
	
	@RequestMapping(value = "/form/editQuestion/{id}.html", method = RequestMethod.GET)
	public String editQuestion(@PathVariable long id, ModelMap models) {
		
		// Get the question Item by ID
		Item item = formDao.getItemById(id);
		
		// Get the Form to which this Item belongs
		Form form = item.getForm();
//		Form form = formDao.getForm(item.getForm().getId());

		models.put( "item", item );
		models.put( "form", form );
//		models.put( "items", form.getItems() );
		models.put( "itemTypes", ItemType.values() );
		
		return "form/editQuestion";
	}
	
	@RequestMapping(value = "/form/editQuestion/{id}.html", method = RequestMethod.POST)
	public String editQuestion(@PathVariable long id, ModelMap models, @ModelAttribute Item item, BindingResult result, SessionStatus sessionStatus) {
		// Get the OLD question Item by ID
		Item oldItem = formDao.getItemById(id);	
		
		// Get the Form to which this Item belongs
		Form form = oldItem.getForm();
//		Form form = formDao.getForm(oldItem.getForm().getId());
		
		item.setForm(form);
		
		// Replace old item with new item
		if ( item.getItemType() == ItemType.CHECKBOX ) {
			form.replaceItem( item.asCheckboxItem() );

			formDao.saveItem( item.asCheckboxItem() );
		} else if ( item.getItemType() == ItemType.TEXT ) {
			form.replaceItem( item.asTextItem() );

			formDao.saveItem( item.asTextItem() );
		}
		
		// Save form to DB
		form = formDao.saveForm( form );
		
		models.put( "item", item );
		models.put( "form", form );
		models.put( "items", form.getItems() );
		models.put( "itemTypes", ItemType.values() );
		
		return "redirect:../edit/" + form.getId() + ".html";
	}
	
	@RequestMapping(value = "/form/addSelection/{id}.html", method = RequestMethod.GET)
	public String addSelection(@PathVariable Integer id, ModelMap models) {

		Item item = formDao.getItemById(id);
		
		models.put( "item", item);
		models.put( "selection", new Selection());

		return "form/addSelection";
	}
	
	@RequestMapping(value = "/form/addSelection/{id}.html", method = RequestMethod.POST)
	public String addSelection(@PathVariable Integer id, ModelMap models, @ModelAttribute Selection selection, BindingResult result, SessionStatus sessionStatus) {

		Item item = formDao.getItemById(id);
		
		selection.setItem(item);
		item.addSelection(selection);
		
		formDao.saveItem(item);

		return "redirect:../editQuestion/" + item.getId() + ".html";	
	}
	
	@RequestMapping(value = "/form/deleteSelection/{id}.html", method = RequestMethod.GET)
	public String deleteSelection( @PathVariable int id, ModelMap models ) {

		Selection selection = formDao.getSelectionById(id);
		formDao.deleteSelection(selection);
		
		return "redirect:../editQuestion/" + selection.getItem().getId() + ".html";
	}
	
	@RequestMapping(value = "/form/editSelection/{id}.html", method = RequestMethod.GET)
	public String editSelection(@PathVariable Integer id, ModelMap models) {
		
		Selection selection = formDao.getSelectionById(id);
		models.put( "selection", selection );

		return "redirect:../editQuestion/" + selection.getItem().getId() + ".html";	
	}
	
	@RequestMapping(value = "/form/editSelection/{id}.html", method = RequestMethod.POST)
	public String editSelection(@PathVariable Integer id, ModelMap models, @ModelAttribute Selection selection, BindingResult result, SessionStatus sessionStatus) {
		
		formDao.saveSelection(selection);

		return "redirect:../editQuestion/" + selection.getItem().getId() + ".html";	//TODO: redirect to edit question
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