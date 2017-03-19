package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.ItemBlock;
import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.ItemPage;
import formbuilder.model.Selection;

public interface FormDao {
	
	Form getForm(Integer id);	
	
	List<Form> getForms();
	
	Form saveForm(Form form);
	
	void deleteForm(Form form);
	
	
	ItemPage getPageById(Integer id);
	
	ItemPage savePage(ItemPage page);
	
	
	List<ItemBlock> getBlocks();
	
	ItemBlock getBlockById(Integer id);
	
	ItemBlock saveBlock(ItemBlock block);
	
	Item getItemById(Integer id);
	
	
	Item saveItem(Item item);
	
	Selection saveSelection(Selection selection);
}
