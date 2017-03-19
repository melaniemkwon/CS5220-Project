package formbuilder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "selections")
 public class Selection implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
 	private int id;
	
 	private int index;
	
	@Column(name = "value")
 	private String value;
	
	@ManyToOne
	private Item item;
 	
 	public Integer getId() {
 		return id;
 	}
 	
 	public void setId(int id) {
 		this.id = id;
 	}
 	
 	public int getIndex() {
 		return index;
 	}
 	
 	public void setIndex(int index) {
 		this.index = index;
 	}
 	
 	public String getValue() {
 		return value;
 	}
 
 	public void setValue(String value) {
 		this.value = value;
 	}
 	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
 }
