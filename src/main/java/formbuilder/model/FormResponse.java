package formbuilder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * A response to the form as a whole. Contains answers.
 */
@Entity
@Table(name = "form_responses")
public class FormResponse implements Serializable  {
	
    private static final long serialVersionUID = 1L;
    
    @Id
	@GeneratedValue
	private long id;
    
    @ManyToOne
    private User respondent;
        
    @OneToMany
    private List<ItemResponse> itemResponses;
    
	@Column(name = "submit_date")
	private Date submitDate;
     
    public FormResponse() {
    	itemResponses = new ArrayList<ItemResponse>();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public User getRespondent() {
		return respondent;
	}

	public void setRespondent(User respondent) {
		this.respondent = respondent;
	}

	public List<ItemResponse> getItemResponses() {
		return itemResponses;
	}

	public void setItemResponses(List<ItemResponse> itemResponses) {
		this.itemResponses = itemResponses;
	}

}
