package formbuilder.model;

public class ItemTextAnswer {

	private Integer id;
	private String answer;  //text input from the user
	private Item item; //match to the items which the answer belongs to
	private User user;
	public ItemTextAnswer(Integer id, String answer, Item item, User user) {
		super();
		this.id = id;
		this.answer = answer;
		this.item = item;
		this.user = user;
	}
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

}
