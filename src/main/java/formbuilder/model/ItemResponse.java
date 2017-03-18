package formbuilder.model;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class ItemResponse implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    Item item;
    
    
    String[] responses;
    
    // Gets the question item that this response answers.
    private Item getItem() {
    	return item;
    }
    
    // Gets the answer that the respondent submitted.
    private String[] getResponses() {
    	return responses;
    }
}
