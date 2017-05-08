package formbuilder.model.questionform;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import formbuilder.model.core.User;

@Entity
@Table(name = "form_status")
public class UserFormStatus {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id", columnDefinition = "int4")
	private User user;
	
	@Column(name = "form_id", columnDefinition = "int4")
	private Form form;
	
	private boolean finished;
}
