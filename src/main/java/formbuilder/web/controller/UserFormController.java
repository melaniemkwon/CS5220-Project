package formbuilder.web.controller;

import java.util.List;
import java.util.Set;

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

import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TextAnswer;
import formbuilder.model.questionform.UserAnswers;
import formbuilder.model.questionform.dao.FormDao;
import formbuilder.model.questionform.dao.UserAnswerDao;

@Controller
@SessionAttributes({ "form", "question", "user" })
public class UserFormController {
	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserAnswerDao answerDao;

	@RequestMapping("/userForm/listForm.html")
	public String listForm(@RequestParam Integer id, ModelMap models) {

		models.put("user", userDao.getUser(id));

		Set<Form> forms = userDao.getUser(id).getForms();

		models.put("forms", forms);

		return "userForm/listForm";
	}
	
	@RequestMapping(value = "/userForm/viewForm.html", method = RequestMethod.GET)
	public String viewForm(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models){
		
		Form form = formDao.getForm(id);
		models.put("form", form);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("questionsPage", questionsPage);
		models.addAttribute("userAnswer", new UserAnswers());
		UserAnswers userAnswer = new UserAnswers();
		
		for(Question q : questionsPage){
			if(q.getType() == "TEXT"){
				Answer ta = new TextAnswer();
				ta.setQuestion(q);
				ta.setUser(models.get(user));
				userAnswer.getAnswers().add(ta);
			}
			if(q.getType() == "CHOICE"){
				Answer ca = new ChoiceAnswer();
				ca.setQuestion(q);
				userAnswer.getAnswers().add(ca);
			}
			
		}
		userAnswer.setAnswers(answers);
		return "userForm/viewPage";
	}
	
	@RequestMapping(value = "/userForm/viewForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute("userAnswer") UserAnswers userAnswer, BindingResult result, ModelMap models){
		
		answerDao.saveAnswers(userAnswer);
		//save user answer
		
		
		return "";
	}
}
