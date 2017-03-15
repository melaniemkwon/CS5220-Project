package formbuilder.model.dao;

import java.util.List;

import formbuilder.model.User;

public interface UsersDao {
	
	List<User> getUsers();
	
	User getUser(Integer id);

	User saveUser( User user );
	
}
