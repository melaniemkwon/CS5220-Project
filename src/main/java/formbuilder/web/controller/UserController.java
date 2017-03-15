package formbuilder.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.User;
import formbuilder.model.dao.UserDao;


@Controller
public class UserController {

	@Autowired
    private UserDao userDao;
	
	@RequestMapping("/user/list.html")
    public String list( ModelMap models ){
		
		// passing the users object to the jsp to list all the users one the webpage.
		List<User> users = userDao.getUsers();
        models.put( "users", users );
        
        return "user/list";
    }
	
	@RequestMapping("/user/{id}.html")
    public String userViewId( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        return "user/view";
    }
	
	
	// get the values from the form about the specific user to modify it. 
	@RequestMapping(value = "/user/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        models.put( "users", userDao.getUsers() );
        return "user/edit";
    }

	// saving after modifying the user info
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute User user, BindingResult result,
        SessionStatus sessionStatus ){

        user =  userDao.saveUser( user );
        sessionStatus.setComplete();
        
        return "redirect:list.html";
    }
	

	
}
