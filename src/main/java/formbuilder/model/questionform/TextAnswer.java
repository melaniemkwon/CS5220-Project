package formbuilder.model.questionform;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TEXT")
public class TextAnswer extends Answer {

	private static final long serialVersionUID = 1L;

	private String text;

	public TextAnswer() {
	}

	@Override
	public String toString() {
		return text != null ? text : "";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
