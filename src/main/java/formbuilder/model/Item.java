package formbuilder.model;

import java.util.List;

public class Item {
	private Integer itemId;
	private String itemName;
	private String description;
	
	public Item(Integer id, String name, String desc){
		itemId = id;
		itemName = name;
		description = desc;
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
