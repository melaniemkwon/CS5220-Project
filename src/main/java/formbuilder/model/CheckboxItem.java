package formbuilder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("CHECKBOX")
public class CheckboxItem extends Item {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "min_selections")
    protected int minSelections;

    @Column(name = "max_selections")
    protected int maxSelections;
    
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
		
		newCheckboxItem.minSelections = this.minSelections;
		newCheckboxItem.maxSelections = this.maxSelections;
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
		return maxSelections == 1;
	}
	
	// TODO: Creates a new ItemResponse for this Checkbox item
	public ItemResponse createResponse(ArrayList<String> checkedChoices) {
		ItemResponse newItemResponse = new ItemResponse();
//		newItemResponse.addResponse(checkedChoices.toString());
		return newItemResponse;
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public int getMinSelections() {
		return minSelections;
	}

	public void setMinSelections(int minSelections) {
		this.minSelections = minSelections;
	}

	public int getMaxSelections() {
		return maxSelections;
	}

	public void setMaxSelections(int maxSelections) {
		this.maxSelections = maxSelections;
	}
}
