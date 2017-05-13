package formbuilder.model.pdfform.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.pdfform.PdfMap;
import formbuilder.model.pdfform.dao.PdfMapDao;
import formbuilder.model.uploadfile.UploadFile;

@Repository
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
	
	@Override
	public List<PdfMap> getPdfMapsByUploadFile(UploadFile uploadFile) {
		System.out.println("DEBUG getting ordered PDFs");
		String query = "from PdfMap pdfMap where :uploadFile =" + uploadFile + " order by orderNum";
		return entityManager.createQuery("from PdfMap pdfMap where :uploadFile =" + uploadFile + " order by orderNum", PdfMap.class).getResultList();
	}

}
