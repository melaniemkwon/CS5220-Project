package formbuilder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "item_blocks")
public class ItemBlock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String name;
	
	private String description;
	
	private boolean available;
	
	/*
	 * block_order renamed to index
	 */
    private int index;
	
//	@ManyToOne
//	private Page page;
	
//	@OneToMany(mappedBy="block",cascade=CascadeType.ALL)
//	@OrderBy("index")
//	@Column(name="item")
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })	
	@JoinColumn(name = "item_block_id")
    @OrderColumn(name = "item_index")
	private List<Item> items;
	
	public ItemBlock() {
		items = new ArrayList<Item>();
	}
	
	public ItemBlock duplicate() {
		ItemBlock newItemBlock = new ItemBlock();
		
		newItemBlock.name = name;
		newItemBlock.description = description;
		newItemBlock.available = available;
		newItemBlock.index = index;
		for ( Item item : items ) {
			newItemBlock.items.add( item.duplicate() );
		}
		
		return newItemBlock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public Page getPage() {
//		return page;
//	}
//
//	public void setPage(Page page) {
//		this.page = page;
//	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

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
