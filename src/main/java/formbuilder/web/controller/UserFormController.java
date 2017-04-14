package formbuilder.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.dao.FormDao;

@Controller
@SessionAttributes({ "form", "question" })
public class UserFormController {
	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/userForm/listForm.html")
	public String listForm(@RequestParam Integer id, ModelMap models) {

		models.put("user", userDao.getUser(id));

		Set<Form> forms = userDao.getUser(id).getForms();

		models.put("forms", forms);

		return "userForm/listForm";
	}
	
	@RequestMapping("/userForm/viewForm.html")
	public String viewForm(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models){
		
		Form form = formDao.getForm(id);
		models.put("form", form);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("questionsPage", questionsPage);
		
		return "userForm/viewPage";
	}
}
