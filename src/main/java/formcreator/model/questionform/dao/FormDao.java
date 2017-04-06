package formcreator.model.questionform.dao;

import java.util.List;

import formcreator.model.questionform.ChoiceQuestion;
import formcreator.model.questionform.Form;
import formcreator.model.questionform.Question;
import formcreator.model.questionform.TextQuestion;

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
