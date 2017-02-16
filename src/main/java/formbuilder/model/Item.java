package formbuilder.model;


public class Item {
	private int id;
	private String name;
	private String description;
	private int orderid;  // in which order this item should be shown, when only by itself the default is 0
	private Block block;
	private boolean isRequired;
	public Item(int id, String name, String description, int orderid, Block block, boolean isRequired) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.orderid = orderid;
		this.block = block;
		this.isRequired = isRequired;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public Block getBlock() {
		return block;
	}
	public void setBlock(Block block) {
		this.block = block;
	}
	public boolean isRequired() {
		return isRequired;
	}
	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	
	
}
