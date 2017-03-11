package formbuilder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity(name = "Item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private boolean available;  //block can be disabled
    
    @Column(name = "order_id")
    private int orderId; // in which order this item should be shown, when only
                            // by itself the default is 0
    @ManyToOne
    private Block block;
    
    public enum Type {
        TEXT,
        RADIOBUTTON,
        CHECKBOX,
        PULLDOWN
    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private Type itemTypes;
    
    @Column(name = "required")
    private boolean isRequired;
    
    @ManyToOne
    private PdfField matchField;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Type getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(Type itemTypes) {
        this.itemTypes = itemTypes;
    }

    public PdfField getMatchField() {
        return matchField;
    }

    public void setMatchField(PdfField matchField) {
        this.matchField = matchField;
    }
}
