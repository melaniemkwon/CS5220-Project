package formbuilder.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "item_text")
@DiscriminatorValue("text")
public class ItemText extends Item{

	private String type;
	private String inputText; 
	private int textLength;
	
}