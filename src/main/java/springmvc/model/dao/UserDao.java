// To test project setup. http://csns.calstatela.edu/wiki/content/cysun/course_materials/cs520/sham/hibernate

package springmvc.model.dao;

import java.util.List;

import springmvc.model.User;

public interface UserDao {

    User getUser( Integer id );

    List<User> getUsers();

}