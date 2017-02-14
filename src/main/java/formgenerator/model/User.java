package formgenerator.model;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
    @GeneratedValue
    @Column(name = "user_id")
	private Integer id;
	
	@Column(name = "last_name")
	private String userLastName;
	@Column(name = "first_name")
	private String userFirstName;
	@Column(name = "email")
	private String email;
	@Embedded
	private UserAddress address;
	@Column(name = "role")
	private Set<String> roles; 
	
	
    
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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
}
