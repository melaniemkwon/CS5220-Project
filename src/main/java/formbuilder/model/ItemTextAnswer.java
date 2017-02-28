package formbuilder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "text_answer")
public class ItemTextAnswer {

	@Id
	@GeneratedValue
	private Integer id;

	private String answer; // text input from the user

	private Item item; // match to the items which the answer belongs to

	private User user;

	private ItemTextAnswer matchItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemTextAnswer getMatchItem() {
		return matchItem;
	}

	public void setMatchItem(ItemTextAnswer matchItem) {
		this.matchItem = matchItem;
	}

}
