package formbuilder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/*
 * A form page contains a list of form blocks
 */
@Entity
@Table(name = "item_pages")
public class ItemPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    private int id;
	
	private String description;
	
	private int index;

	private boolean available;
	
	@ManyToOne
	private Form form;
	
	@OneToMany(mappedBy="page", cascade = CascadeType.ALL)
//    @JoinColumn(name = "item_page_id")
//    @OrderColumn(name = "block_index")
	private List<ItemBlock> blocks;
	
	public ItemPage() {
		blocks = new ArrayList<ItemBlock>();
		blocks.add( new ItemBlock() );  // Add Block to new Page
	}
	
	public ItemPage duplicate() {
		ItemPage newItemPage = new ItemPage();
		
		newItemPage.index = index;
		newItemPage.available = available;
		for ( ItemBlock block : blocks ) {
			newItemPage.blocks.add(block);
		}
		
		return newItemPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ItemBlock> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<ItemBlock> blocks) {
		this.blocks = blocks;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}
	
}