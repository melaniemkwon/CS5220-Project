package formbuilder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/*
 * A question item that allows the respondent to select one or more checkboxes
 */
@Entity
@DiscriminatorValue("CHECKBOX")
public class CheckboxItem extends Item {
	
	private static final long serialVersionUID = 1L;

    @Column(name = "single_response")
	protected boolean singleResponse;
       
    public CheckboxItem() {
    	super();
    	itemType = ItemType.CHECKBOX;
    	selections = new ArrayList<Selection>();
    }
    
    public CheckboxItem( Item item ) {
    	this.form = item.form;
    	itemType = ItemType.CHECKBOX;
    	selections = new ArrayList<Selection>();
    	this.title = item.title;
    	this.description = item.description;
    	this.available =  item.available;
    	this.orderNum = item.orderNum;
    	this.required = item.required;
    }

	@Override
	public Item duplicate() {
		CheckboxItem newCheckboxItem = new CheckboxItem();
		
		// repetitive..
		newCheckboxItem.title = this.title;
		newCheckboxItem.description = this.description;
		newCheckboxItem.available = this.available;
		newCheckboxItem.orderNum = this.orderNum;
		newCheckboxItem.required = this.required;
		newCheckboxItem.form = this.form;
		
		for ( Selection selection : selections) {
			newCheckboxItem.selections.add( selection );
		}
		
		return newCheckboxItem;
	}
	
	public Selection createSelection( String text, int orderNum ) {
		Selection selection = new Selection();
		selection.setItem(this);
		selection.setValue(text);
		selection.setIndex(orderNum);
		return selection;
	}
	
	public void addSelection( Selection selection ) {
		selections.add( selection );
	}

	public Selection deleteSelection( int selectionId ) {
		for (int i = 0; i < selections.size(); i++) {
			if (selections.get(i).getId() == selectionId) {
				return selections.remove(i);
			}
		}
		return null;
	}
	
	public boolean isSingleSelectOnly() {
		return selections.size() == 1;
	}
	
	// Creates a new ItemResponse for this Checkbox item
	// and adds it to list of ItemResponses
	public void createResponse(ArrayList<String> checkedChoices) {
		ItemResponse newItemResponse = new ItemResponse();
		
		for ( String checkedChoice : checkedChoices ) {
			newItemResponse.addResponse( checkedChoice );
		}
		
		responses.add(newItemResponse);
	}
	
	// For single-selection checkbox scenarios
	// Creates a new ItemResponse for this Checkbox item and 
	// adds TRUE or FALSE to list of ItemResponses
	public void createResponse() {
		ItemResponse newItemResponse = new ItemResponse();
		
		if (singleResponse) {
			newItemResponse.addResponse( "TRUE" );
		} else if (!singleResponse) {
			newItemResponse.addResponse( "FALSE" );
		}
				
		responses.add(newItemResponse);
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public String getHelpText() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSingleResponse() {
		return singleResponse;
	}

	public void setSingleResponse(boolean singleResponse) {
		this.singleResponse = singleResponse;
	}
	
}
