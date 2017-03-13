package formbuilder.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.Form;
import formbuilder.model.dao.FormsDao;

public class FormsDaoImp implements FormsDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
    public List<Form> getForms(){
		
        return entityManager.createQuery( "from Form order by id", Form.class )
            .getResultList();
    }
	
	@Override
	public Form getForm( Integer id ) {
		return entityManager.find(Form.class, id);
	}
	
	@Override
	@Transactional
	public Form saveForm( Form form ) {
		return entityManager.merge(form);
	}
}
