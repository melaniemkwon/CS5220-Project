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

@SessionAttributes({ "form", "question", "questionsPage","user","userAnswer" })

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
		User user = SecurityUtils.getUser();
		models.put("form", form);
		models.put("id", id);
		models.put("pageNum", pageNum);
		List<Question> questionsPage = form.getQuestionsPage(pageNum);
		UserAnswers userAnswer = new UserAnswers();
		ArrayList<String> answers = new ArrayList<>();
		boolean started = false;
		
		for(Question q : questionsPage){
			//get all answers for this question
			//List<Answer> ans = q.getAnswers();
			Answer ans = answerDao.getAnswers(q, user);
			if(ans != null){
				System.out.println("test");
				started = true;
				if(q.getType().equals("TEXT")){
					TextAnswer ta = (TextAnswer) ans;
					answers.add(ta.getText());
				}else{
					ChoiceAnswer ca = (ChoiceAnswer) ans;
					for(String c : ca.getChoices()){
						answers.add(c);
					}
				}
			}else{
				answers.add(" ");
			}
			/*for (Answer a : ans){
				//get the answer from this user
				if(a.getUser().equals(user)){
					System.out.println("test");
					started = true;
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
					System.out.println("null " + user.getId());
					answers.add(" ");
				}
			}*/
		}
		System.out.println("size " + answers.size() + " " + answers.get(0) + ' ' + started);
		userAnswer.setAnswers(answers);
		models.put("questionsPage", questionsPage);
		models.addAttribute("userAnswer", userAnswer);
		models.put("answerlist",answers);
		models.put("user", user);
		
		if(started == false){
			models.put("size", 0);
		}else{
			models.put("size", answers.size());
		}
		
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
