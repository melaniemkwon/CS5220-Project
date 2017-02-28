package formbuilder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "block")
public class Block {
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String description;
	private int pid; // parent form page id
	
	@OneToMany
	@Column(name="item")
	private List<Item> items;
}
