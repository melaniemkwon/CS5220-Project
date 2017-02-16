package formbuilder.model;

import java.util.List;

public class User {
	
	private Integer id;
	private String lastName;
	private String firstName;
	private String email;
	private UserAddress address;
	public enum Role {
	    ADMIN,
	    USER
	}
	public Role roleTypes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public Role getRoleTypes() {
		return roleTypes;
	}
	public void setRoleTypes(Role roleTypes) {
		this.roleTypes = roleTypes;
	}
	
}
