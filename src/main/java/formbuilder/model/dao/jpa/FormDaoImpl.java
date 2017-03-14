package formbuilder.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.Form;
import formbuilder.model.Page;
import formbuilder.model.dao.FormDao;

@Repository
public class FormDaoImpl implements FormDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Form getForm(Integer id) {
		return entityManager.createQuery("from form where id = :formid",Form.class)
				.setParameter("formid", id)
				.getSingleResult();
	}

	@Override
	public List<Form> getForms() {
		return entityManager.createQuery("from form order by id",Form.class).getResultList();
	}

	@Override
	@Transactional
	public Form saveForm(Form form) {
		return entityManager.merge(form);
	}

	//get specific page from a form
	@Override
	public Page getPage(Form form, Integer pageNum) {
		String query = "from User where form = :form and pageNumber = :pagenum ";
		List<Page> pages = entityManager.createQuery( query, Page.class )
	            .setParameter( "form", form )
	            .setParameter( "pagenum", pageNum )
	            .getResultList();
		return pages.size() == 0 ? null : pages.get( 0 );
		
	}

	@Override
	public List<Page> getPages(Form form) {
		return entityManager.createQuery("from page where form = :form",Page.class)
				.setParameter("form", form)
				.getResultList();
	}

	@Override
	@Transactional
	public Page savePage(Page page) {
		
		return entityManager.merge(page);
	}

}
