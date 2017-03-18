package formbuilder.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHECKBOX")
public class CheckboxItem extends Item {
	
	private static final long serialVersionUID = 1L;
	
	protected List<String> choices;
	
	@Column(name = "min_selections")
    protected int minSelections;

    @Column(name = "max_selections")
    protected int maxSelections;
    
    public CheckboxItem() {
    	choices = new ArrayList<String>();
    }

	@Override
	public Item duplicate() {
		CheckboxItem newCheckboxItem = new CheckboxItem();
		
		newCheckboxItem.name = this.name;
		newCheckboxItem.description = this.description;
		newCheckboxItem.available = this.available;
		newCheckboxItem.index = this.index;
		newCheckboxItem.isRequired = this.isRequired;
		newCheckboxItem.itemType = this.itemType;
		
		return newCheckboxItem;
	}

	@Override
	public ItemType getItemType() {
		return ItemType.CHECKBOX;
	}
	
	public boolean isSingleSelectOnly() {
		return maxSelections == 1;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
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
