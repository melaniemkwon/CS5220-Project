package formbuilder.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@Entity
@Table(name = "page")
public class Page {


	
	
	@Id
    @GeneratedValue
    @Column(name = "page_id")
	private Integer id;
	
	@Column(name="page_number")
	private int pageNumber;
	
	
    @ManyToOne
    @JoinColumn(name = "form_id")
    private Form form_mapped;


    @ManyToOne
    @JoinColumn(name = "page_id")
    private Page block_mapped_pages;
}

