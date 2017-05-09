package formbuilder.model.questionform.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.core.User;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.UserFormStatus;
import formbuilder.model.questionform.dao.FormStatusDao;

@Repository
@Transactional
public class FormStatusDaoImpl implements FormStatusDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public UserFormStatus getFormStatus(User user, Form form) {
		List<UserFormStatus> formStatus = entityManager
				.createQuery("from UserFormStatus where user = :user and form = :form",
						UserFormStatus.class)
				.setParameter("user", user).setParameter("form", form).getResultList();
		return formStatus.size() == 0 ? null : formStatus.get(0);
	}
	
	@Override
	public UserFormStatus saveFormStatus(UserFormStatus formStatus) {
		return entityManager.merge(formStatus);
	}

}
