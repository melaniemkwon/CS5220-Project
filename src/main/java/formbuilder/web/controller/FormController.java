package formbuilder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import formbuilder.model.Form;
import formbuilder.model.dao.FormsDao;

@Controller
@SessionAttributes({ "forms", "form" })
public class FormController {
	
	@Autowired
	private FormsDao form;

	@RequestMapping("/admin/formManagement.html")
	public String list( ModelMap models ) {
		models.put("forms", form.getForms());
		
		return "admin/formManagement.html";
	}
	
	@RequestMapping("/admin/formView.html")
	public String view( @RequestParam Integer id, ModelMap models ) {
		models.put("form", form.getForm( id ));
		
		return "admin/formView.html";
	}
}
