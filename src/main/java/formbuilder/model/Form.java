package formbuilder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
/*
 * Form is the main data structure that contains question pages... UNDER CONSTRUCTION
 * Form responses can be created or accessed from a Form.
 */
@Entity
@Table(name = "forms")
public class Form implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	private String description;
	
	private boolean available; 
	
	@OneToMany(mappedBy="form")
	private List<FormResponse> formResponses;
	
	@ManyToOne
	private User creator;	//ADMIN or STAFF that creates the form
	
	@OneToMany(mappedBy="form", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	// @JoinColumn(name = "item_block_id")
	// @OrderColumn(name = "item_index")
	private List<Item> items;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@Column(name = "finished")
	private boolean isfinished;
	
	@OneToMany(mappedBy = "form")	//double check this...
	private Set<Pdf> pdfs;
	
	public Form() {
		this.available = false;
		this.createDate = new Date();
		this.updateDate = createDate;
		this.isfinished = false;	
	}
	
	public Item getItem(int itemId) {
		for (Item item : items) {
			if (item.getId() == itemId) {
				return item;
			}
		}
		return null;
	}

	public Item deleteItem(int itemId) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == itemId) {
				return items.remove(i);
			}
		}
		return null;
	}

	// TODO: void replaceItem( Item item )
	
	/*
	 * Open a form by ID and add a new item.
	 */
	public CheckboxItem addCheckboxItem() {
		CheckboxItem item = new CheckboxItem();
		item.form = this;
		return item;
	}
	
	public DateItem addDateItem() {
		DateItem item = new DateItem();
		item.form = this;
		return item;
	}
	
	public DropdownListItem addDropdownListItem() {
		DropdownListItem item = new DropdownListItem();
		item.form = this;
		return item;
	}
	
	public MultipleChoiceItem addMultipleChoiceITem() {
		MultipleChoiceItem item = new MultipleChoiceItem();
		item.form = this;
		return item;
	}
	
	public PageBreakItem addPageBreakItem() {
		PageBreakItem item = new PageBreakItem();
		item.form = this;
		return item;
	}
	
	public ImageItem addImageItem() {
		ImageItem item = new ImageItem();
		item.form = this;
		return item;
	}
	
	public SectionHeaderItem addSectionHeaderItem() {
		SectionHeaderItem item = new SectionHeaderItem();
		item.form = this;
		return item;
	}
	
	public TextItem addTextItem() {
		TextItem item = new TextItem();
		item.form = this;
		return item;
	}
	
	public TextParagraphItem addTextParagraphItem() {
		TextParagraphItem item = new TextParagraphItem();
		item.form = this;
		return item;
	}
	
	public TimeItem addTimeItem() {
		TimeItem item = new TimeItem();
		item.form = this;
		return item;
	}
	
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isIsfinished() {
		return isfinished;
	}
	
	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}

	public List<FormResponse> getFormResponses() {
		return formResponses;
	}

	public void setFormResponses(List<FormResponse> formResponse) {
		this.formResponses = formResponse;
	}

	public Set<Pdf> getPdfs() {
		return pdfs;
	}

	public void setPdfs(Set<Pdf> pdfs) {
		this.pdfs = pdfs;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
