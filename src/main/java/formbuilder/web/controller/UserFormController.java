package formbuilder.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import formbuilder.model.questionform.UserAnswers;
import formbuilder.model.questionform.dao.AnswerDao;
import formbuilder.model.questionform.dao.FormDao;

@Controller
@SessionAttributes({ "form", "question", "questionsPage" })
public class UserFormController {
	@Autowired
	private FormDao formDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AnswerDao answerDao;

	@RequestMapping("/userForm/listForm.html")
	public String listForm(@RequestParam Integer id, ModelMap models) {

		models.put("user", userDao.getUser(id));

		Set<Form> forms = userDao.getUser(id).getForms();

		models.put("forms", forms);

		return "userForm/listForm";
	}
	
	@RequestMapping(value="/userForm/fillForm.html", method = RequestMethod.GET)
	public String viewForm(@RequestParam Integer id, @RequestParam Integer pageNum, ModelMap models){
		
		Form form = formDao.getForm(id);
		models.put("form", form);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("questionsPage", questionsPage);
		UserAnswers userAnswer = new UserAnswers();
		models.addAttribute("userAnswer", userAnswer);
		
		return "userForm/viewPage";
	}
	
	@RequestMapping(value="/userForm/fillForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute UserAnswers userAnswer, @ModelAttribute List<Question> questionsPage, @ModelAttribute User user, SessionStatus status){
		
		ArrayList<Answer> answers = (ArrayList<Answer>) userAnswer.getAnswers();
		for(int i=1;i<=answers.size();i++){
			
			for (Question q : questionsPage){
				//find out which question it's for
				if(q.getQuestionNumber()== i){
					if(q.getType().equals("TEXT")){
						TextAnswer ans = (TextAnswer) answers.get(i);
						ans.setQuestion(q);
						ans.setUser(user);
						answerDao.saveAnswer(ans);
					}else{
						ChoiceAnswer ans = (ChoiceAnswer) answers.get(i);
						ans.setSelected(true);
						ans.setQuestion(q);
						ans.setUser(user);
					}
				}
			}
		}
		
		return "userForm/listForm";
	}
}
