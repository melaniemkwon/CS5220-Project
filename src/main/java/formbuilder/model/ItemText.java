package formbuilder.model;

public class ItemText extends Item{

	private String type;
	private String inputText; 
	private int textLength;
	
	public ItemText(int id, String name, String description, int orderid, Block block, boolean isRequired) {
		super(id, name, description, orderid, block, isRequired);

	}
}