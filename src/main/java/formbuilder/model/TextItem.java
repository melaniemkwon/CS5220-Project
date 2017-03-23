package formbuilder.model;

import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/*
 * A question item that allows the respondent to enter a single line of text.
 */
@Entity
@DiscriminatorValue("TEXT")
public class TextItem extends Item {
	
	private static final long serialVersionUID = 1L;
	
	public TextItem() {
		super();
		itemType = ItemType.TEXT;
	}

	@Override
	public Item duplicate() {
		TextItem newTextItem = new TextItem();
		
		// repetitive..
		newTextItem.title = this.title;
		newTextItem.description = this.description;
		newTextItem.available = this.available;
		newTextItem.orderNum = this.orderNum;
		newTextItem.required = this.required;
		newTextItem.form = this.form;
				
		return newTextItem;
	}

    public TextItem( Item item ) {
    	this.form = item.form;
    	itemType = ItemType.TEXT;
    	selections = new ArrayList<Selection>();
    	this.title = item.title;
    	this.description = item.description;
    	this.available =  item.available;
    	this.orderNum = item.orderNum;
    	this.required = item.required;
    }
    
	public ItemType getItemType() {
		return itemType;
	}
	
	// Creates a new ItemResponse for this date item
	// and adds it to list of ItemResponses
	public void createResponse(String response) {
		ItemResponse newItemResponse = new ItemResponse();
		newItemResponse.addResponse( response );
		responses.add(newItemResponse);
	}

	public String getHelpText() {
		// TODO Auto-generated method stub
		return null;
	}

}
