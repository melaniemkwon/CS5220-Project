package formbuilder.model.pdfform.dao;

import formbuilder.model.pdfform.PdfMap;

public interface PdfMapDao {
	PdfMap save(PdfMap pdfMap);
	
	void delete(Integer id);
	
	PdfMap getPdfMap(Integer id);
	
}
