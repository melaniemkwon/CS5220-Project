package formbuilder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.Form;
import formbuilder.model.dao.FormsDao;

@Controller
@SessionAttributes({ "forms", "form" })
public class FormController {
	
	@Autowired
	private FormsDao formDao;

	@RequestMapping("/admin/formManagement.html")
	public String list( ModelMap models ) {
		models.put("forms", formDao.getForms());
		
		return "admin/formManagement";
	}
	
	@RequestMapping("/admin/formView.html")
	public String view( @RequestParam Integer id, ModelMap models ) {
		models.put("form", formDao.getForm( id ));
		
		return "admin/formView";
	}
	
	@RequestMapping(value = "/admin/formAdd.html", method = RequestMethod.GET)
	public String add( @RequestParam Integer id, ModelMap models ) {
		
		models.put("form", new Form());
		models.put("forms", formDao.getForms());
		
		return "admin/formAdd";
	}
	
	@RequestMapping(value = "/admin/formAdd.html", method = RequestMethod.POST)
	public String add( @ModelAttribute Form form, BindingResult result ) {
		
		// TODO: add formValidator here
		// if (result.hasErrors() ) return "admin/formAdd";
		
		form = formDao.saveForm( form );
		
		return "redirect:formView.html";
	}
	
	@RequestMapping(value = "/admin/formEdit.html", method = RequestMethod.GET)
	public String edit( @RequestParam Integer id, ModelMap models ) {
		models.put("form", formDao.getForm( id ));
		models.put("forms", formDao.getForms());
		
		return "admin/formEdit";
	}
	
	@RequestMapping(value = "/admin/formEdit.html", method = RequestMethod.POST)
	public String edit( @ModelAttribute Form form, BindingResult result, SessionStatus sessionStatus ) {
		
		// TODO: add formValidator here
		// if (result.hasErrors() ) return "admin/formEdit";
		
		form = formDao.saveForm( form );
		sessionStatus.setComplete();
		
		return "redirect:formView.html";
	}
}
