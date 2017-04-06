package formcreator.model.questionform;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@DiscriminatorValue("CHOICE")
public class ChoiceQuestion extends Question {

	private static final long serialVersionUID = 1L;

	@ElementCollection
	@CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
	@Column(name = "choice")
	protected List<String> choices;

	public ChoiceQuestion() {
		super.setDescription("New Choice Question");
		choices = new ArrayList<String>();
		choices.add("choice 1");
		choices.add("choice 2");
	}

	@Override
	public String getType() {
		return "CHOICE";
	}

	public List<Boolean> getChoiceSelections() {
		List<Boolean> choiceSelections = new ArrayList<Boolean>();

		for (Answer answer : answers)
			choiceSelections.add(((ChoiceAnswer) answer).isSelected());

		return choiceSelections;
	}

	public int getNumOfChoices() {
		return choices.size();
	}

	public void setNumOfChoices(int numOfChoices) {
		if (numOfChoices <= 0)
			numOfChoices = 1;

		if (numOfChoices > choices.size())
			for (int i = choices.size(); i < numOfChoices; ++i)
				choices.add("");

		if (numOfChoices < choices.size())
			for (int i = choices.size(); i > numOfChoices; --i) {
				choices.remove(i - 1);
			}
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}

	@Override
	public Question clone() {
		ChoiceQuestion newQuestion = new ChoiceQuestion();

		newQuestion.description = description;
		newQuestion.questionNumber = questionNumber + 1;
		newQuestion.form = form;
		newQuestion.pageNumber = pageNumber;
		newQuestion.tagAttribute.required = tagAttribute.required;
		newQuestion.tagAttribute.type = tagAttribute.type;
		newQuestion.tagAttribute.inputType = tagAttribute.inputType;
		newQuestion.tagAttribute.size = tagAttribute.size;
		newQuestion.tagAttribute.placeholder = tagAttribute.placeholder;
		newQuestion.tagAttribute.rows = tagAttribute.rows;
		newQuestion.tagAttribute.min = tagAttribute.min;
		newQuestion.tagAttribute.max = tagAttribute.max;
		newQuestion.tagAttribute.step = tagAttribute.step;
		newQuestion.choices = new ArrayList<>(choices);

		return newQuestion;
	}
}
