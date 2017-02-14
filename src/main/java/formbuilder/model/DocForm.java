package formbuilder.model;

import java.util.List;

public class DocForm {
	private Integer docId;
	private String docName;
	private String description;
	private List<Item> items;
	
	public DocForm(Integer id, String name, String desc){
		docId = id;
		docName = name;
		description = desc;
	}

	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
