package formbuilder.model.uploadFileDao;

import java.util.List;

import formbuilder.model.uploadfile.UploadFile;

public interface FileUploadDAO {
	UploadFile save(UploadFile uploadFile);

	void deleteFile(String fileName);
	
	UploadFile getFile(String fileName);
	
	UploadFile getFile(long id);
	
	List<UploadFile> getFiles();

}
