package formbuilder.model.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import formbuilder.model.questionform.FileAnswer;

@Entity
@Table(name = "files")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	private String type;

	private User owner;

	private boolean deleted;

	@ManyToOne
	private FileAnswer fileAnswer;

	public File() {
		deleted = false;
	}

	public boolean isSameFile(File file) {
		return file != null && file.getId().equals(id);
	}

	public static String getFileExtension(String fileName) {
		int lastDotIndex = fileName.lastIndexOf('.');
		return lastDotIndex != -1 ? fileName.substring(lastDotIndex + 1) : "";
	}

	public String getFileExtension() {
		return File.getFileExtension(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public FileAnswer getFileAnswer() {
		return fileAnswer;
	}

	public void setFileAnswer(FileAnswer fileAnswer) {
		this.fileAnswer = fileAnswer;
	}

}
