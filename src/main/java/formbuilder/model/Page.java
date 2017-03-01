package formbuilder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "page")
public class Page {
	@Id
    @GeneratedValue
	private int id;
	@Column(name="page_number")
	private int pageNumber;
	@ManyToOne
	private Form form; // parent form
	
	@OneToMany
	@Column(name="block")
	private List<Block> block;
}