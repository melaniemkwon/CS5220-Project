package formbuilder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity(name = "page")
public class Page {
	@Id
    @GeneratedValue
	private int id;
	@Column(name="page_number")
	private int pageNumber;
	@ManyToOne
	private Form form; // parent form
	
	private boolean available; //page can be disabled
	
	@OneToMany(mappedBy="page",cascade=CascadeType.ALL)
	@OrderBy("blockOrder")
	@Column(name="block")
	private List<Block> block;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public List<Block> getBlock() {
		return block;
	}

	public void setBlock(List<Block> block) {
		this.block = block;
	}
}