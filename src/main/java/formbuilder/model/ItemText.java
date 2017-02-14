package formbuilder.model;

public class ItemText extends Item{
	
	public ItemText(Integer id, String name, String desc) {
		super(id, name, desc);
	}
	private String type;
	private String inputText; 
	private Integer textLength;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public Integer getTextLength() {
		return textLength;
	}

	public void setTextLength(Integer textLength) {
		this.textLength = textLength;
	}
}
