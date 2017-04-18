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
		UserAnswers userAnswer = new UserAnswers();
		ArrayList<String> answers = new ArrayList<>();
		
		for(Question q : questionsPage){
			//get all answers for this question
			List<Answer> ans = q.getAnswers();
			for (Answer a : ans){
				//get the answer from this user
				if(a.getUser().equals(user)){
					if(q.getType().equals("TEXT")){
						TextAnswer ta = (TextAnswer) a;
						answers.add(ta.getText());
					}else{
						ChoiceAnswer ca = (ChoiceAnswer) a;
						for(String c : ca.getChoices()){
							answers.add(c);
						}
					}
				}else{
					//no answer from this user
				}
			}
		}
		userAnswer.setAnswers(answers);
		models.put("questionsPage", questionsPage);
		//models.addAttribute("userAnswer", userAnswer);
		models.put("userAnswer",userAnswer);
		models.put("user", user);
		
		return "userForm/viewPage";
	}
	
	@RequestMapping(value="/userForm/fillForm.html", method = RequestMethod.POST)
	public String fillForm(@ModelAttribute UserAnswers userAnswer, @RequestParam Integer id, @RequestParam Integer pageNum, SessionStatus status, ModelMap models){
		ArrayList<String> answers = (ArrayList<String>) userAnswer.getAnswers();
		Form form = formDao.getForm(id);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		User user = SecurityUtils.getUser();
		
		//loop through every answer
		for(int i=1;i<=answers.size();i++){
			//System.out.println("answer:" + i + " " + answers.get(i) + " end");
			for (Question q : questionsPage){
				//find out which question it's for
				if(q.getQuestionNumber() == i){
					if(q.getType().equals("TEXT")){
						TextAnswer ans = new TextAnswer();
						ans.setText(answers.get(i));
						ans.setQuestion(q);
						ans.setUser(user);
						answerDao.saveAnswer(ans);
						
					}else{
						ChoiceAnswer ans = new ChoiceAnswer();
						ArrayList<String> selectedChoices = new ArrayList<>();
						//split by "," for multiple answers
						String[] answerlist =  answers.get(i).split(",");
						if(answerlist.length > 1){
							for(int n=0; n<answerlist.length; n++){
								System.out.println("list" + i + " " + answerlist[n]);
								selectedChoices.add(answerlist[n]);
							}
							
						}else{
							selectedChoices.add(answerlist[0]);
						}
						ans.setChoices(selectedChoices); 
						ans.setQuestion(q);
						ans.setUser(user);
						answerDao.saveAnswer(ans);
					}
				}
			}
		}
		
		return "userForm/listForm";
	}
}
