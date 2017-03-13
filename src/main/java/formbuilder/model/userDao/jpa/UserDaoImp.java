package formbuilder.model.userDao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import formbuilder.model.User;
import formbuilder.userDao.UsersDao;

@Repository
public class UserDaoImp implements UsersDao{
	
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
    public List<User> getUsers(){
		
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

	
}
