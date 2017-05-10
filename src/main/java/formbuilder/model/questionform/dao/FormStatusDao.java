package formbuilder.model.questionform.dao;

import formbuilder.model.core.User;
import formbuilder.model.questionform.Form;
import formbuilder.model.questionform.UserFormStatus;

public interface FormStatusDao {
	UserFormStatus getFormStatus(User user, Form form);
	UserFormStatus saveFormStatus(UserFormStatus formStatus);
}
