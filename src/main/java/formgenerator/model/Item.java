package formgenerator.model;

import java.util.List;

public class Item {
	private int itemId;
	private String itemName;
	private String description;
	private Integer parentItemId;
	private boolean isRequired;
	private int orderid;  // in which order this item should be shown, when only by itself the default is 0
	
	public Item(Integer id, String name, String desc, Integer pid){
		itemId = id;
		itemName = name;
		description = desc;
		parentItemId = pid;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
