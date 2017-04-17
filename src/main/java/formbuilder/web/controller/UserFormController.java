package formbuilder.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.core.User;
import formbuilder.model.core.dao.UserDao;
import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.ChoiceAnswer;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TextAnswer;
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

	@RequestMapping(value = "/userForm/fillForm.html", method = RequestMethod.GET)
	public String fillForm(@RequestParam Integer uId, @RequestParam Integer fId, @RequestParam Integer pageNum,
			ModelMap models) {

		User user = userDao.getUser(uId);
		Form form = formDao.getForm(fId);
		List<Question> questions = form.getQuestions();
		for (Question question : questions) {
			List<Answer> answers = question.getAnswers();
			boolean found = false;

			if (answers.size() > 0) {
				for (Answer answer : answers) {
					if (answer.getUser().equals(user)) {
						found = true;
						answers.set(0, answer);
						break;
					}
				}
			}
			if (!found) {
				if (question.getType().equals("TEXT")) {
					TextAnswer newAnswer = new TextAnswer();
					newAnswer.setUser(user);
					newAnswer.setQuestion(question);
					if (answers.size() > 0)
						answers.set(0, newAnswer);
					else
						answers.add(newAnswer);
				} else if (question.getType().equals("CHOICE")) {
					ChoiceAnswer newAnswer = new ChoiceAnswer();
					newAnswer.setUser(user);
					newAnswer.setQuestion(question);
					answers.set(0, newAnswer);
				}
			}
		}

		models.put("form", form);

		models.put("uId", uId);
		models.put("fId", fId);
		models.put("pageNum", pageNum);

		return "userForm/fillForm";
	}

	@RequestMapping(value = "/userForm/fillForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute Form form, @RequestParam Integer uId, @RequestParam Integer fId,
			@RequestParam Integer pageNum, SessionStatus sessionStatus) {

		formDao.saveForm(form);
		sessionStatus.setComplete();
		return "redirect:/userForm/fillForm.html?uId=" + uId + "&fId=" + fId + "&pageNum=" + pageNum;
	}
}
