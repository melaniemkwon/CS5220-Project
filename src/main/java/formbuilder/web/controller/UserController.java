package formbuilder.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import formbuilder.model.User;
import formbuilder.model.dao.UsersDao;


@Controller
public class UserController {

	@Autowired
    private UsersDao user;
	
	@RequestMapping("/userList.html")
    public String list( ModelMap models ){
		
		// passing the users object to the jsp to list all the users one the webpage.
		List<User> users = user.getUsers();
        models.put( "users", users );
        
        return "userList";
    }
}
