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
	
}