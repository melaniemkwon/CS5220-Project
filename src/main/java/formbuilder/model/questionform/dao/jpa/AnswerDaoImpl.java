package formbuilder.model.questionform.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.core.User;
import formbuilder.model.questionform.Answer;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.dao.AnswerDao;

@Repository
@Transactional
public class AnswerDaoImpl implements AnswerDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Answer saveAnswer(Answer answer) {
		return entityManager.merge(answer);
	}

	@Override
	public Answer getAnswers(Question question, User user) {
		List<Answer> answers = entityManager
				.createQuery("from Answer where question = :question and user = :user", Answer.class) 
				.setParameter("question", question)
				.setParameter("user", user)
				.getResultList();
		
		return answers.size() == 0 ? null :answers.get(0);
	}

}
