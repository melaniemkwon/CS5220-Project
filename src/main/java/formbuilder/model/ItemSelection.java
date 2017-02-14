package formbuilder.model;

import java.util.List;

public class ItemSelection extends Item{

	public ItemSelection(Integer id, String name, String desc) {
		super(id, name, desc);
	}
	private String type;
	private List<String> selections; 
	private Integer minRequirements; //(ex. Needs to pick at lease 1)
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getSelections() {
		return selections;
	}
	public void setSelections(List<String> selections) {
		this.selections = selections;
	}
	public Integer getMinRequirements() {
		return minRequirements;
	}
	public void setMinRequirements(Integer minRequirements) {
		this.minRequirements = minRequirements;
	}
	
	
}
