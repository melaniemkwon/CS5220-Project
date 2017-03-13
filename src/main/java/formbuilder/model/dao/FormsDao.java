package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.Form;

public interface FormsDao {
	List<Form> getForms();
	
	Form getForm( Integer id );
}
