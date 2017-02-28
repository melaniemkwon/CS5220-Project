package formbuilder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Page {
	@Id
    @GeneratedValue
	private int id;
	private int pageNumber;
	private int pid; // parent form id
	
	@OneToMany
	@Column(name="block")
	private List<Block> block;
}