package formbuilder.web.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.Form;
import formbuilder.model.Page;
import formbuilder.model.User;
import formbuilder.model.dao.FormDao;
import formbuilder.model.dao.UserDao;
import formbuilder.model.dao.UsersDao;
import formbuilder.web.validator.UserValidator;


@Controller
@SessionAttributes({ "user", "users" })
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/user/list.html")
    public String list( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "user/list";
    }

    @RequestMapping("/user/view.html")
    public String view1( @RequestParam Integer id, ModelMap models )
    {								
    	System.out.println("String view1");
        models.put( "user", userDao.getUser( id ) );
        return "user/view";
    }	

    @RequestMapping("/user/{id}.html")
    public String view2( @PathVariable Integer id, ModelMap models )
    {
    	System.out.println("String view2");
        models.put( "user", userDao.getUser( id ) );
        return "user/view";
    }
	
	
    @RequestMapping(value = "/user/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Integer id, ModelMap models )
    {
        models.put( "user", userDao.getUser( id ) );
        models.put( "users", userDao.getUsers() );
        return "user/edit";
    }

    @RequestMapping(value = "/user/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute User user, BindingResult result,
        SessionStatus sessionStatus )
    {
        userValidator.validate( user, result );
        if( result.hasErrors() ) return "user/edit";

        user = userDao.saveUser( user );
        sessionStatus.setComplete();
        return "redirect:list.html";
    }

    @RequestMapping(value = "/user/add.html", method = RequestMethod.GET)
    public String add( ModelMap models )
    {
        models.put( "user", new User() );
        models.put( "users", userDao.getUsers() );
        return "user/add";
    }

    @RequestMapping(value = "/user/add.html", method = RequestMethod.POST)
    public String add( @ModelAttribute User user, BindingResult result )
    {
        userValidator.validate( user, result );
        if( result.hasErrors() ) return "user/add";

        user = userDao.saveUser( user );
        return "redirect:list.html";
    }
    
    @RequestMapping(value = "/user/delete.html" )
    public String deleteUser(@RequestParam int id, HttpServletResponse response) {
		User user = userDao.getUser(id);
		userDao.delete(user);
		return "redirect:list.html";
    }

    
//    @RequestMapping(value = "/user/delete/{id}.html", method = RequestMethod.DELETE)
//	public String delete_User(@PathVariable int id, HttpServletResponse response) {
//		User user = userDao.getUser(id);
//		userDao.delete(user);
//		return "redirect:list.html";
//	}
    

 
	
}
