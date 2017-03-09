package formbuilder.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "item_text")
public class ItemText extends Item {
	
	@Column(name="text_length")
	private int textLength;
	
	@OneToOne(mappedBy="item",cascade=CascadeType.ALL)
	private ItemTextAnswer answer;
	
	public int getTextLength() {
		return textLength;
	}
	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}
	public ItemTextAnswer getTextAnswer() {
		return answer;
	}
	public void setTextAnswer(ItemTextAnswer textAnswer) {
		this.answer = textAnswer;
	}
	
}

