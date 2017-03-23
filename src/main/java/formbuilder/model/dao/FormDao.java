package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.Selection;

public interface FormDao {
	
	Form getForm(long id);	
	
	List<Form> getForms();
	
	Form saveForm(Form form);
	
	void deleteForm(Form form);
	
	
	Item getItemById(long id);
	
	Item saveItem(Item item);
	
	void deleteItem(Item item);
	
	Selection saveSelection(Selection selection);
	
	Selection getSelectionById(int id);

	void deleteSelection(Selection selection);
}
