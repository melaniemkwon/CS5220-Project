package formbuilder.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "form")
public class Form {
	@Id
    @GeneratedValue
	private Integer id;
	private String name;
	private String description;

	@OneToMany
	@Column(name="page")
	private List<Page> pages;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "submit_date")
	private Date submitDate;
	private boolean available; 	// form can be disabled for example if the admin wants to make changes
	@Column(name = "finished")
	private boolean isfinished;
}