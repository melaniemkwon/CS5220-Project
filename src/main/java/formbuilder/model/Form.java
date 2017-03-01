package formbuilder.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "form")
public class Form {
	

   
    @Id
    @GeneratedValue
    @Column(name = "form_id")
	private Integer id;
	private String name;
	private String description;


	
    @OneToMany(mappedBy = "form_mapped", cascade = CascadeType.ALL)
    @OrderBy("page_id")
    private List<Page> pages;
	
	
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "submit_date")
	
    @Temporal(TemporalType.DATE)
	private Date submitDate;
	
	private boolean available; 	// form can be disabled for example if the admin wants to make changes
	@Column(name = "finished")
	private boolean isfinished;
}


///don't have a way to '