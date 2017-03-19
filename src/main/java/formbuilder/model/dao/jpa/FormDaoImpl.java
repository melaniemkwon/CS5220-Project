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
	public Form getForm( Integer id ) {
		return entityManager.find(Form.class, id);
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

//	public ItemPage getPageById(Integer id){
//		return entityManager.find(ItemPage.class, id);
//	}
//	
//	@Override
//	@Transactional
//	public ItemPage savePage(ItemPage page) {
//		
//		return entityManager.merge(page);
//	}
	
//	@Override
//	@Transactional
//	public ItemBlock saveBlock(ItemBlock block) {
//		
//		return entityManager.merge(block);
//	}
//
//	@Override
//	public List<ItemBlock> getBlocks() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public ItemBlock getBlockById(Integer id) {
//		return entityManager.find(ItemBlock.class, id);
//	}

	@Override
	@Transactional
	public Item saveItem(Item item) {
		return entityManager.merge(item);
	}

	@Override
	@Transactional
	public Selection saveSelection(Selection selection) {
		return entityManager.merge(selection);
	}

	@Override
	public Item getItemById(Integer id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	@Transactional
	public void deleteForm(Form form) {
		entityManager.remove(form);
		
	}
}
