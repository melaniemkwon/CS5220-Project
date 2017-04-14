package formbuilder.model.questionform.dao;

import formbuilder.model.questionform.UserAnswers;

public interface UserAnswerDao {
	UserAnswers saveAnswers(UserAnswers answers);
}
