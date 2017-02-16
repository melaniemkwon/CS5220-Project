package formbuilder.model;

import org.springframework.expression.spel.ast.Selection;

public class ItemSelectionAnswer {
	private Integer id;
	private Selection selection;
	private boolean value; //true : selected -- we just need to know which option are selected
	private User user;
	
	public ItemSelectionAnswer(Integer id, Selection selection, boolean value, User user) {
		super();
		this.id = id;
		this.selection = selection;
		this.value = value;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
