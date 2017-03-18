package formbuilder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_responses")
public class ItemResponse implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue
	private long id;
    
    @ManyToOne	// TODO: check this.. if correct logic
    private Item item;	// the question item that this response answers.
    
    // TODO: customize?
    @ElementCollection
    private List<String> responses; // the answers that the respondent submitted.
    
    public ItemResponse() {
    	responses = new ArrayList<String>();
    }
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
    private Item getItem() {
    	return item;
    }
    
	public void setItem(Item item) {
		this.item = item;
	}

	private List<String> getResponses() {
    	return responses;
    }	
	
	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
	
	public void addResponse(String response) {
		this.responses.add( response );
	}
}
