package formbuilder.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DATE")
public class DateItem extends Item {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Item duplicate() {
		DateItem newDateItem = new DateItem();
		
		newDateItem.name = this.name;
		newDateItem.description = this.description;
		newDateItem.available = this.available;
		newDateItem.index = this.index;
		newDateItem.isRequired = this.isRequired;
		newDateItem.itemType = this.itemType;
		newDateItem.block = this.block;
		
		return newDateItem;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.DATE;
	}
	
	// Creates a new ItemResponse for this date item
	public ItemResponse createResponse(Date date) {
		ItemResponse newItemResponse = new ItemResponse();
		newItemResponse.addResponse(date.toString());
		return newItemResponse;
	}

}
