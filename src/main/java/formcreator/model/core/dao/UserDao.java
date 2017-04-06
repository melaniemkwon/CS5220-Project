package formcreator.model.core.dao;

import java.util.List;

import formcreator.model.core.User;

public interface UserDao {

	User getUser(Integer id);

	List<User> getUsers();

	User saveUser(User user);

}
