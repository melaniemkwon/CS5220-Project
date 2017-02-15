package formbuilder.model;
public class Selection {
 	private int selectionId;
 	private int orderId;
 	private String name;
 	private String value;
 	private String description;
 	private int parentId;
 	
 	public Selection(int order,String name, String value, int pid){
 		this.orderId = order; //order to be shown in the parent item
 		this.name = name;
 		this.value = value;  //default: false, when get selected then turn into true
 		this.parentId = pid; //parent selection item id
 	}
 	
 	public int getId() {
 		return selectionId;
 	}
 	public void setId(int id) {
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
 
 	public int getParentId() {
 		return parentId;
 	}
 
 	public void setParentId(int parentId) {
 		this.parentId = parentId;
 	}
 }
