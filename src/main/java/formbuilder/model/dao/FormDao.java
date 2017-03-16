package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.Block;
import formbuilder.model.Form;
import formbuilder.model.Item;
import formbuilder.model.Page;
import formbuilder.model.Selection;

public interface FormDao {
	
	Form getForm(Integer id);	
	List<Form> getForms();
  Form saveForm(Form form);
  void deleteForm(Form form);
	
	Page getPageById(Integer id);
	Page savePage(Page page);
	
	List<Block> getBlocks();
	Block getBlockById(Integer id);
	Block saveBlock(Block block);
	
	Item getItemById(Integer id);
	Item saveItem(Item item);
	
	Selection saveSelection(Selection selection);
}
