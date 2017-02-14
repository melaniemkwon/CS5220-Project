package formgenerator.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ItemSelection extends Item{
	
	public ItemSelection(Integer id, String name, String desc, Integer pid) {
		super(id, name, desc, pid);
		
	}
	private String type;  //radio button, checkbox, etc
	private List<Selection> selections;
	private Integer minSelectionNum; //(ex. Needs to pick at lease 1)
	private Integer maxSelectionNum; //(ex. maximum number to select, can be select 2 out of 5, so max=2)
	
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
	public Integer getMinSelectionNum() {
		return minSelectionNum;
	}
	public void setMinSelectionNum(Integer minSelectionNum) {
		this.minSelectionNum = minSelectionNum;
	}
	public Integer getMaxSelectionNum() {
		return maxSelectionNum;
	}
	public void setMaxSelectionNum(Integer maxSelectionNum) {
		this.maxSelectionNum = maxSelectionNum;
	}
	
	
}
