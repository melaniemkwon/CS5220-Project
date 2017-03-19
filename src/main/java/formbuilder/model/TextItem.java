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
		newTextItem.title = this.title;
		newTextItem.description = this.description;
		newTextItem.available = this.available;
		newTextItem.orderNum = this.orderNum;
		newTextItem.isRequired = this.isRequired;
		newTextItem.form = this.form;
				
		return newTextItem;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.TEXT;
	}
	
	// Creates a new ItemResponse for this date item
	// and adds it to list of ItemResponses
	public void createResponse(String response) {
		ItemResponse newItemResponse = new ItemResponse();
		newItemResponse.addResponse( response );
		responses.add(newItemResponse);
	}

	@Override
	public String getHelpText() {
		// TODO Auto-generated method stub
		return null;
	}

}
