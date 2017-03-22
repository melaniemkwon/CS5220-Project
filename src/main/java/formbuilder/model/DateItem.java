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
		
		newDateItem.title = this.title;
		newDateItem.description = this.description;
		newDateItem.available = this.available;
		newDateItem.orderNum = this.orderNum;
		newDateItem.required = this.required;
		newDateItem.form = this.form;
		
		return newDateItem;
	}

	public ItemType getItemType() {
		return itemType;
	}
	
	// Creates a new ItemResponse for this date item
	public ItemResponse createResponse(Date date) {
		ItemResponse newItemResponse = new ItemResponse();
		newItemResponse.addResponse(date.toString());
		return newItemResponse;
	}

	public String getHelpText() {
		// TODO Auto-generated method stub
		return null;
	}

}
