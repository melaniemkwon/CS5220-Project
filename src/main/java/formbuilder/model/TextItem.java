package formbuilder.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*
 * A question item that allows the respondent to enter a single line of text.
 */
@Entity
@DiscriminatorValue("TEXT")
public class TextItem extends Item {
	
	private static final long serialVersionUID = 1L;

	@Override
	public Item duplicate() {
		TextItem newTextItem = new TextItem();
		
		// repetitive..
		newTextItem.name = this.name;
		newTextItem.description = this.description;
		newTextItem.available = this.available;
		newTextItem.index = this.index;
		newTextItem.isRequired = this.isRequired;
		newTextItem.itemType = this.itemType;
		newTextItem.block = this.block;
				
		return newTextItem;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.TEXT;
	}
	
	// Creates a new ItemResponse for this date item
	public ItemResponse createResponse(String response) {
		ItemResponse newItemResponse = new ItemResponse();
		newItemResponse.addResponse( response );
		return newItemResponse;
	}

}
