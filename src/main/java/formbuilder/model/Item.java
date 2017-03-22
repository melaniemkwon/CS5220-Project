package formbuilder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@DiscriminatorColumn(name = "item_discriminator")
public class Item implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    protected long id;
    
    protected String title;
    
    protected String description;
    
    @Column(name = "item_type")
    protected ItemType itemType;
    
    protected String helpText;
    
    protected boolean available;

    @Column(name = "order_num")
    protected int orderNum; 	
    
    protected boolean required;
    
//    @ManyToOne
//    private PdfField matchField;
    
    @ManyToOne
	protected Form form;
    
//    @Column(name = "selection_count")
//    protected int selectionCount;
    
	@OneToMany(mappedBy="item", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	protected List<Selection> selections;
	
    @OneToMany(mappedBy="item")		// TODO: check this.. if correct logic
    protected List<ItemResponse> responses;
    
    public Item() {
    	this.available = true;
    	this.required = false;
    }
    
//  public abstract ItemType getItemType();
//	public abstract String getHelpText();
	
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
	
	public Item duplicate() {
		Item item = new Item();
		
		// repetitive..
		item.title = this.title;
		item.description = this.description;
		item.available = this.available;
		item.orderNum = this.orderNum;
		item.required = this.required;
		item.form = this.form;
		
		return item;
	}
	
	public CheckboxItem asCheckboxItem() {
		return new CheckboxItem( this );
	}
//	
//	public DropdownListItem asDropdownListItem() {
//		return new DropdownListItem( this );
//	}
//	
//	public MultipleChoiceItem asMultipleChoiceItem() {
//		return new MultipleChoiceItem( this );
//	}
	
	public TextItem asTextItem() {
		return new TextItem( this );
	}
//	
//	public TextParagraphItem asTextParagraphItem() {
//		return new TextParagraphItem( this );
//	}
//	
//	public DateItem asDateItem() {
//		return new DateItem( this );
//	}
//	
//	public TimeItem asTimeItem() {
//		return new TimeItem( this );
//	}
//	
//	public ImageItem asImageItem() {
//		return new ImageItem( this );
//	}
//	
//	public PageBreakItem asPageBreakItem() {
//		return new PageBreakItem( this );
//	}
//	
//	public SectionHeaderItem asSectionHeaderItem() {
//		return new SectionHeaderItem( this );
//	}
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
    
    public ItemType getItemType() {
    	return itemType;
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

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int index) {
		this.orderNum = orderNum;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

//	public int getSelectionCount() {
//		return selectionCount;
//	}
//
//	public void setSelectionCount(int selectionCount) {
//		this.selectionCount = selectionCount;
//	}

	public List<ItemResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ItemResponse> responses) {
		this.responses = responses;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}
}
