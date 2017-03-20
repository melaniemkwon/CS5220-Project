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
    	selections = new ArrayList<Selection>();
    }

	@Override
	public Item duplicate() {
		CheckboxItem newCheckboxItem = new CheckboxItem();
		
		// repetitive..
		newCheckboxItem.title = this.title;
		newCheckboxItem.description = this.description;
		newCheckboxItem.available = this.available;
		newCheckboxItem.orderNum = this.orderNum;
		newCheckboxItem.isRequired = this.isRequired;
		newCheckboxItem.form = this.form;
		
		for ( Selection selection : selections) {
			newCheckboxItem.selections.add( selection );
		}
		
		return newCheckboxItem;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.CHECKBOX;
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

	@Override
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
