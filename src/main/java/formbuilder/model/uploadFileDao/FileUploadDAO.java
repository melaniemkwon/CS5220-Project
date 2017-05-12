package formbuilder.model.uploadFileDao;

import formbuilder.model.uploadfile.UploadFile;

public interface FileUploadDAO {
	UploadFile save(UploadFile uploadFile);

	void deleteFile(String fileName);
	
	UploadFile getFile(String fileName);

}
