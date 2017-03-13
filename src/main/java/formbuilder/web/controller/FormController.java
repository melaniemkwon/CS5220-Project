package formbuilder.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import formbuilder.model.Form;
import formbuilder.model.dao.FormsDao;

@Controller
public class FormController {
	
	@Autowired
	private FormsDao form;

	@RequestMapping("/admin/FormManagement.html")
	public String list( ModelMap models ) {
		models.put("form", form.getForms());
		
		return "admin/FormManagement.html";
	}
}
