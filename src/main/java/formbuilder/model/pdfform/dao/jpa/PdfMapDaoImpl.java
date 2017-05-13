package formbuilder.model.pdfform.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.core.User;
import formbuilder.model.pdfform.PdfMap;
import formbuilder.model.pdfform.dao.PdfMapDao;

public class PdfMapDaoImpl implements PdfMapDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public PdfMap save(PdfMap pdfMap) {
		return entityManager.merge(pdfMap);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		entityManager.remove(getPdfMap(id));
	}

	@Override
	public PdfMap getPdfMap(Integer id) {
		return entityManager.find(PdfMap.class, id);
	}

}
