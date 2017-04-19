package formbuilder.model.questionform;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceAnswer extends Answer {

	private static final long serialVersionUID = 1L;

	private boolean selected;
	
	@ElementCollection
	private List<String> choices;

	public ChoiceAnswer() {

	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {

		this.choices = choices;
	}

}
