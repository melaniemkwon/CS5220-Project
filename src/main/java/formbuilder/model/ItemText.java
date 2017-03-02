package formbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "item_text")
public class ItemText extends Item {

	private String type;
	@Column(name="input_text")
	private String inputText; 
	@Column(name="textLength")
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
	public int getTextLength() {
		return textLength;
	}
	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}
	
	
	
}

