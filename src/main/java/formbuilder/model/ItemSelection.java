package formbuilder.model;

import java.util.List;

public class ItemSelection extends Item {

	private String type;
	private List<Selection> selections;
	private int minRequirements; // (ex. Needs to pick at lease 1)
	private int maxSelectionNum; //(ex. maximum number to select, can be select 2 out of 5, so max=2)}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public Integer getMinRequirements() {
		return minRequirements;
	}

	public void setMinRequirements(Integer minRequirements) {
		this.minRequirements = minRequirements;
	}

}
