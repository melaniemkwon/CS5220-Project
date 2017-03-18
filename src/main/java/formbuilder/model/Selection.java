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
	@Column(name = "selection_id")
 	private Integer selectionId;
	
	@Column(name = "order_id")
 	private int orderId;
	
	@Column(name = "name")
 	private String name;
	
	@Column(name = "value")
 	private String value;
	
	@Column(name = "description")
 	private String description;
	
	@ManyToOne
	private ItemSelection item;
 	
 	public Integer getId() {
 		return selectionId;
 	}
 	
 	public void setId(Integer id) {
 		this.selectionId = id;
 	}
 	
 	public int getOrderId() {
 		return orderId;
 	}
 	
 	public void setOrderId(int orderId) {
 		this.orderId = orderId;
 	}
 	
 	public String getName() {
 		return name;
 	}
 	
 	public void setName(String name) {
 		this.name = name;
 	}
 	
 	public String getValue() {
 		return value;
 	}
 
 	public void setValue(String value) {
 		this.value = value;
 	}
 
 	public String getDescription() {
 		return description;
 	}
 	
 	public void setDescription(String description) {
 		this.description = description;
 	}
 
 	public int getSelectionId() {
 		return selectionId;
 	}
 
 	public void setSelectionId(int selectionId) {
 		this.selectionId = selectionId;
 	}
 	
	public ItemSelection getItem() {
		return item;
	}
	
	public void setItem(ItemSelection item) {
		this.item = item;
	}
	
 }
