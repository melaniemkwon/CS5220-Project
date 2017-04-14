package formbuilder.model.questionform.dao.jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.UserAnswers;
import formbuilder.model.questionform.dao.UserAnswerDao;

@Repository
@Transactional
public class UserAnswerDaoImpl implements UserAnswerDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserAnswers saveAnswers(UserAnswers ua) {
		ArrayList<Answer> answers = (ArrayList<Answer>) ua.getAnswers();
		UserAnswers useranswers = new UserAnswers();
		for(Answer answer : answers){
			useranswers.getAnswers().add(entityManager.merge(answer));
		}
		return useranswers;
	}

}
