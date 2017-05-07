package formbuilder.model.questionform;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import formbuilder.model.core.File;

@Entity
@DiscriminatorValue("FILE")
public class FileAnswer extends Answer {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "fileAnswer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<File> files;

	public FileAnswer() {
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

}
