package formbuilder.model.uploadfile;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import formbuilder.model.pdfform.PdfMap;
import formbuilder.model.questionform.Form;

@Entity
@Table(name = "files_upload")
public class UploadFile {

	@Id
	@GeneratedValue
	@Column(name = "FILE_ID")
	private long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_DATA")
	private byte[] data;
	
	@OneToOne
	private Form form;
	
	@OneToMany(mappedBy = "uploadFile", cascade = CascadeType.ALL)
	private List<PdfMap> pdfMaps;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<PdfMap> getPdfMaps() {
		sortPdfMaps();
		return pdfMaps;
	}
	
	public void sortPdfMaps() {
		//Sort by order number
		Collections.sort(pdfMaps, new Comparator<PdfMap>() {
			public int compare(PdfMap p1, PdfMap p2) {
				return p1.getOrderNum() - p2.getOrderNum();
			}
		});
	}

	public void setPdfMaps(List<PdfMap> pdfMaps) {
		this.pdfMaps = pdfMaps;
	}
	
	public void addPdfMap(PdfMap pdfMap) {
		pdfMap.setUploadFile(this);
		pdfMaps.add(pdfMap);
	}
	
	public void removePdfMap(PdfMap pdfMap) {
		pdfMaps.remove(pdfMap);
		if (pdfMap != null) {
			pdfMap.setUploadFile(null);
		}
	}
	
	public void resetPdfMaps() {
//		for (PdfMap pdfMap : pdfMaps) {
//			pdfMap.setUploadFile(null);
//		}
		pdfMaps.clear();
	}
	
}