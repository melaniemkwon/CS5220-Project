package formbuilder.model.uploadfileDaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.questionform.Form;
import formbuilder.model.uploadFileDao.FileUploadDAO;
import formbuilder.model.uploadfile.UploadFile;

@Repository
public class FileUploadDAOImpl implements FileUploadDAO {

	@PersistenceContext
	private EntityManager entityManager;


	public FileUploadDAOImpl() {
	}

	// public FileUploadDAOImpl(SessionFactory sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }

	@Override
	@Transactional
	public UploadFile save(UploadFile uploadFile) {
		return entityManager.merge(uploadFile);
	}

	@Override
	@Transactional
	public UploadFile getFile(String fileName) {
		return entityManager.find(UploadFile.class, fileName);
	}
	
	@Override
	@Transactional
	public UploadFile getFile(long id) {
		return entityManager.find(UploadFile.class, id);
	}

	@Override
	@Transactional
	public void deleteFile(String fileName) {
		entityManager.remove(getFile(fileName));
	}

	@Override
	public List<UploadFile> getFiles() {
		return entityManager.createQuery("from UploadFile order by id", UploadFile.class).getResultList();
	}
}
