package formbuilder.model.uploadfile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
}