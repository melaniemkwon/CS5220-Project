package formbuilder.model.questionform.dao;

import formbuilder.model.core.User;
import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;

public interface AnswerDao {
	Answer saveAnswer(Answer answer);
	
	Answer getAnswers(Question question, User user);

}
