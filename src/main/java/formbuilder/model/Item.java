package formbuilder.model;

import java.io.Serializable;

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
import javax.persistence.Table;
/*
 * A generic form item that contains properties common to all items
 */
@Entity
@Table(name = "items")
@Inheritance
@DiscriminatorColumn(name = "item_type")
public abstract class Item implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;
    
    private String description;
    
    private boolean available;
    
    /*
     * Renamed from orderId
     * The order this item should be shown. Default is 0
     */
    private int index; 	
    
    /*
     * Class Block has been renamed to ItemBlock
     */
//    @ManyToOne
//    private Block block;
    
    /*
     * Type has been moved out of Item class and remamed ItemType
     */
//    public enum Type {
//        TEXT,
//        RADIOBUTTON,
//        CHECKBOX,
//        PULLDOWN
//    }
    
    @Enumerated(EnumType.ORDINAL)	// TODO: check this
    @Column(name = "type")
    private ItemType itemType;
    
    @Column(name = "required")
    private boolean isRequired;
    
//    @ManyToOne
//    private PdfField matchField;
    
    public Item() {
    	
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

//    public Block getBlock() {
//        return block;
//    }
//
//    public void setBlock(Block block) {
//        this.block = block;
//    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public ItemType getItemType() {
        return itemType;
    }

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
}
