package formbuilder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * A generic form item that contains properties common to all items.
 * Item subclasses for form elements are: 
 * 		CheckboxItem, DropdownListItem, MultipleChoiceItem, 
 * 		TextItem, TextParagraphItem, DateItem, TimeItem
 * Item subclasses for non-form elements are:
 * 		ImageItem, PageBreakItem, SectionHeaderItem
 */
@Entity
@Table(name = "items")
@Inheritance
@DiscriminatorColumn(name = "item_type")
public abstract class Item implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    protected int id;
    
    protected String name;
    
    protected String description;
    
    protected boolean available;

    protected int index; 	
    
    @Enumerated(EnumType.ORDINAL)	// TODO: check this? Don't think needed
    @Column(name = "type")
    protected ItemType itemType;
    
    @Column(name = "required")
    protected boolean isRequired;
    
//    @ManyToOne
//    private PdfField matchField;
    
    @ManyToOne
    protected ItemBlock block;
    
	@OneToMany(mappedBy="item")
	protected List<Selection> selections;
    
    @OneToMany(mappedBy="item")		// TODO: check this.. if correct logic
    protected List<ItemResponse> responses;
    
    public Item() {
    	this.available = true;
    	this.isRequired = false;
    }
    
    public abstract Item duplicate();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public abstract ItemType getItemType();

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

//    public PdfField getMatchField() {
//        return matchField;
//    }
//
//    public void setMatchField(PdfField matchField) {
//        this.matchField = matchField;
//    }

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ItemBlock getBlock() {
		return block;
	}

	public void setBlock(ItemBlock block) {
		this.block = block;
	}
}
