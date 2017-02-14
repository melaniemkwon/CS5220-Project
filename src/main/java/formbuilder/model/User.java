package formbuilder.model;

import java.util.List;

public class User {
	
	private Integer id;
	private String userLastName;
	private String userFirstName;
	private String email;
	private UserAddress address;
	private List<String> roles;  //admin:0, user:1
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	
	
}
