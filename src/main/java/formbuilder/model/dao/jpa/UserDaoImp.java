package formbuilder.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formbuilder.model.User;
import formbuilder.model.dao.UsersDao;

@Repository
public class UserDaoImp implements UsersDao {
	
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Override
    public List<User> getUsers(){
		
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }

	@Override
    public User getUser(Integer id){
		
        return entityManager.find( User.class, id );
    }

	@Override
	@Transactional
	public User saveUser(User user) {
		
		 return entityManager.merge( user );

	}

	
}
