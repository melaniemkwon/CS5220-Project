package formgenerator.model;

public class ItemText extends Item{
	

	public ItemText(Integer id, String name, String desc, Integer pid) {
		super(id, name, desc, pid);
	}

	private String type;
	private String inputText; 
	private int textLength;

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
