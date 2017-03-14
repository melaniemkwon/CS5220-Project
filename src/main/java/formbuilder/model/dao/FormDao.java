package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.Form;
import formbuilder.model.Page;

public interface FormDao {
	
	Form getForm(Integer id);
	List<Form> getForms();
	Form saveForm(Form form);
	
	Page savePage(Page page);

}
