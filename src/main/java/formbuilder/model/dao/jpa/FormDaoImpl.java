package formbuilder.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.Selection;
import formbuilder.model.dao.FormDao;

@Repository
public class FormDaoImpl implements FormDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Form getForm( long id ) {
		return entityManager.find(Form.class, id);
	}

	@Override
	public List<Form> getForms() {
		return entityManager.createQuery("from Form order by id",Form.class).getResultList();
	}

	@Override
	@Transactional
	public Form saveForm(Form form) {
		return entityManager.merge(form);
	}
	
	@Override
	@Transactional
	public void deleteForm(Form form) {
		entityManager.remove(form);
	}

	@Override
	@Transactional
	public Item saveItem(Item item) {
		return entityManager.merge(item);
	}
	
	@Override
	@Transactional
	public void deleteItem(Item item) {
		entityManager.remove(item);
	}

	@Override
	@Transactional
	public Selection saveSelection(Selection selection) {
		return entityManager.merge(selection);
	}

	@Override
	public Item getItemById(long id) {
		return entityManager.find(Item.class, id);
	}
}
