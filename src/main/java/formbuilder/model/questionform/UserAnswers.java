package formbuilder.model.questionform;

import java.util.ArrayList;
import java.util.List;

import formbuilder.model.core.User;

public class UserAnswers {
	private List<Answer> answers;
	
	public UserAnswers(){
		answers = new ArrayList<Answer>();
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	public void setUserAnswers(User user, Question question){
		ArrayList<Answer> ans = new ArrayList<>();
		for(Answer a : ans){
			a.setUser(user);
			a.setQuestion(question);
		}
		this.setAnswers(ans);
		
	}
}
