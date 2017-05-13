package formbuilder.model.pdfform.dao;

import java.util.List;

import formbuilder.model.pdfform.PdfMap;
import formbuilder.model.uploadfile.UploadFile;

public interface PdfMapDao {
	PdfMap save(PdfMap pdfMap);
	
	void delete(Integer id);
	
	PdfMap getPdfMap(Integer id);
	
	public List<PdfMap> getPdfMapsByUploadFile(UploadFile uploadFile);
	
}
