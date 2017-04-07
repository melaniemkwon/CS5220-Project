package formbuilder.model.questionform.dao;

import java.util.List;

import formbuilder.model.questionform.ChoiceQuestion;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.Question;
import formbuilder.model.questionform.TextQuestion;

public interface FormDao {

	Form getForm(int id);

	Question getQuestion(int qId);

	List<Form> getForms();

	Form saveForm(Form form);

	void deleteForm(int id);

	Question saveQuestion(Question question);

	Question getQuestion(int questionNumber, int pageNumber);

	TextQuestion getTextQuestion(int qId);

	ChoiceQuestion getChoiceQuestion(int qId);

}
