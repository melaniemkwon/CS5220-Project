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

    @Column(name = "num_checkboxes")
    protected int numCheckboxes;
    
    public CheckboxItem() {
    	selections = new ArrayList<Selection>();
    }

	@Override
	public Item duplicate() {
		CheckboxItem newCheckboxItem = new CheckboxItem();
		
		// repetitive..
		newCheckboxItem.name = this.name;
		newCheckboxItem.description = this.description;
		newCheckboxItem.available = this.available;
		newCheckboxItem.index = this.index;
		newCheckboxItem.isRequired = this.isRequired;
		newCheckboxItem.itemType = this.itemType;
		newCheckboxItem.block = this.block;
		
		newCheckboxItem.numCheckboxes = this.numCheckboxes;
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
		return numCheckboxes == 1;
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

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public int getNumCheckboxes() {
		return numCheckboxes;
	}

	public void setNumCheckboxes(int numCheckboxes) {
		this.numCheckboxes = numCheckboxes;
	}
}
