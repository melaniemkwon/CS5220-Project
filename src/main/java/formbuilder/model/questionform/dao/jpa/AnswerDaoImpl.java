package formbuilder.model.questionform.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.questionform.Answer;
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
	
	
	

}
