package formbuilder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name = "block")
public class Block {
	@Id
	@Column(name = "block_id")
    @GeneratedValue
	private int id;
	
	private String name;
	private String description;
	
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "page_id")
	private Page page;

	
	@OneToMany(mappedBy = "block_mapped", cascade = CascadeType.ALL)
	@OrderBy("item_id")
	private List<Item> items;

	
    
    @OneToMany(mappedBy = "block_mapped_pages", cascade = CascadeType.ALL)
    @OrderBy("page_id")
    private List<Page> pages;

	
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
