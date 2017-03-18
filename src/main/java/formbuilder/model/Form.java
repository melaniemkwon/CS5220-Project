package formbuilder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
/*
 * Form is the main data structure that contains question pages... UNDER CONSTRUCTION
 */
@Entity
@Table(name = "forms")
public class Form implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private String description;
	
	private boolean available; 
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	protected User creator;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_page_id")
    @OrderColumn(name = "page_index")
	private List<ItemPage> pages;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
//	@Column(name = "submit_date") //moved to FormResponse
//	private Date submitDate;
	
	@Column(name = "finished")
	private boolean isfinished;
	
	@OneToMany(mappedBy = "form")	//double check this...
	private Set<Pdf> pdfs;
	
	public Form() {
		this.available = false;
		this.createDate = new Date();
		this.updateDate = createDate;
		this.isfinished = false;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<ItemPage> getPages() {
		return pages;
	}
	
	public void setPages(List<ItemPage> pages) {
		this.pages = pages;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	public Date getSubmitDate() {
		return submitDate;
	}
	
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public boolean isIsfinished() {
		return isfinished;
	}
	
	public void setIsfinished(boolean isfinished) {
		this.isfinished = isfinished;
	}
}
