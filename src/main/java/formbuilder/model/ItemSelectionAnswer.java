package formbuilder.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "selection_answer")
public class ItemSelectionAnswer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private Integer id;

	@OneToMany
	@Column(name="selected")
	private Set<Selection> selection;   //a list of selected options' id
	
	@ManyToOne
	private User user;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Selection> getSelection() {
		return selection;
	}

	public void setSelection(Set<Selection> selection) {
		this.selection = selection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
