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
import formbuilder.model.questionform.ChoiceQuestion;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TextAnswer;
import formbuilder.model.questionform.UserAnswers;
import formbuilder.model.questionform.dao.AnswerDao;
import formbuilder.model.questionform.dao.FormDao;
import formbuilder.security.SecurityUtils;

@Controller
@SessionAttributes({ "form", "question", "questionsPage","user" })
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
	public String viewForm(@RequestParam Integer id, @RequestParam Integer pageNum, @ModelAttribute User user, ModelMap models){
		
		Form form = formDao.getForm(id);
		models.put("form", form);
		models.put("id", id);
		models.put("pageNum", pageNum);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		models.put("questionsPage", questionsPage);
		UserAnswers userAnswer = new UserAnswers();
		models.addAttribute("userAnswer", userAnswer);
		models.put("user", user);
		
		return "userForm/viewPage";
	}
	
	@RequestMapping(value="/userForm/fillForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute UserAnswers userAnswer, @RequestParam Integer id, @RequestParam Integer pageNum, SessionStatus status){
		ArrayList<String> answers = (ArrayList<String>) userAnswer.getAnswers();
		Form form = formDao.getForm(id);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		
		//loop through every answer
		for(int i=1;i<=answers.size();i++){
			for (Question q : questionsPage){
				//find out which question it's for
				if(q.getQuestionNumber() == i){
					if(q.getType().equals("TEXT")){
						TextAnswer ans = new TextAnswer();
						ans.setText(answers.get(i));
						ans.setQuestion(q);
						User user = SecurityUtils.getUser();
						ans.setUser(user);
						answerDao.saveAnswer(ans);
					}else{
						ChoiceAnswer ans = new ChoiceAnswer();
						ArrayList<String> selectedChoices = new ArrayList<>();
						//select 1,2
						int selectedNum =Integer.parseInt(answers.get(i));
						ChoiceQuestion cq = (ChoiceQuestion) q;
						//loop through all choices of this question
						for(int j=0; j< cq.getChoices().size();j++){
							if(j == selectedNum){
								selectedChoices.add(cq.getChoices().get(j));
							}
						}
						//ans.setChoices(choices); 
						//ans.setSelected(true);
						//ans.setQuestion(q);
						//ans.setUser(user);
					}
				}
			}
		}
		
		return "userForm/listForm";
	}
}
