package formbuilder.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import formbuilder.model.User;
import formbuilder.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public User getUser(Integer id) {
        
		return entityManager.createQuery("from User where user_id = :userid", User.class)
				.setParameter("userid", id)
				.getSingleResult();
	}

	@Override
	public List<User> getUsers() {
		
		return entityManager.createQuery("from User order by user_id", User.class)
				.getResultList();
	}

	@Override
	public User saveUser(User user) {
		return null;
	}

	@Override
	public User getUserByUsername(String name) {
		return null;
	}

}
