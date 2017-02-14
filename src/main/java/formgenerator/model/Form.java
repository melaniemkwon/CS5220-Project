package formgenerator.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class Form {
	@Id
    @GeneratedValue
    @Column(name = "form_id")
	private Integer formId;
	
	private String formName;
	private String description;
	private List<Item> items;
	private Date creatDate;
	private Date updateDate;
	private Date submitDate;
	private boolean available; //form can be disabled for example if the admin wants to make changes
	private boolean isfinished;
	
	@Column(name = "user")
	private List<User> users;
	

	public Integer getformId() {
		return formId;
	}
	public void setformId(Integer formId) {
		this.formId = formId;
	}
	public String getformName() {
		return formName;
	}
	public void setformName(String formName) {
		this.formName = formName;
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
