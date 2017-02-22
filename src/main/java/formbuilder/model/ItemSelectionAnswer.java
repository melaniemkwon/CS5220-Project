package formbuilder.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "selection_answer")
public class ItemSelectionAnswer {
	@Id
    @GeneratedValue
	private Integer id;
	@OneToMany
	private Set<Selection> selection;
	
	@ManyToOne
	private User user;
	@OneToOne
	private ItemSelectionAnswer matchItem;

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

	public ItemSelectionAnswer getMatchItem() {
		return matchItem;
	}

	public void setMatchItem(ItemSelectionAnswer matchItem) {
		this.matchItem = matchItem;
	}
}
