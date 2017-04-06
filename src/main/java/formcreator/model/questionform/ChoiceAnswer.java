package formcreator.model.questionform;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceAnswer extends Answer {

	private static final long serialVersionUID = 1L;

	private boolean selected;

	public ChoiceAnswer() {

	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
