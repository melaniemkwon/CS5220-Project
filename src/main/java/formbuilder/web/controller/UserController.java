package formbuilder.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import formbuilder.model.Role;
import formbuilder.model.User;
import formbuilder.model.dao.UserDao;

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/user/list.html")
	public String users( ModelMap models ){
		
		List<User> users = userDao.getUsers();
		models.put("users", users);
		
		return "user/list";
	}
	
	@RequestMapping("/user/view.html")
	public String view(@RequestParam Integer id, ModelMap models){
		models.put("user",userDao.getUser(id));
		return "user/view";
	}
	
	@RequestMapping("/user/view/{id}.html")
	public String view1(@PathVariable Integer id, ModelMap models){
		return view(id,models);
	}
	
	@RequestMapping(value="/user/add1.html", method=RequestMethod.GET)
	public String add1(){
		return "user/add1";
	}
	
	@RequestMapping(value = "/user/add1.html", method = RequestMethod.POST)
    public String add1(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String email, @RequestParam String userRole)
    {
    	User user = new User();
    	user.setFirstName(firstName);;
    	user.setLastName(lastName);
    	user.setEmail(email);
    	Role role = null;
    	switch(userRole){
    	case "ADMIN":
    		role = Role.ADMIN;
    		user.setRole(role);
    	case "STAFF":
    		role = Role.STAFF;
    		user.setRole(role);
    	case "USER":
    		role = Role.USER;
    		user.setRole(role);
    	}
    	
    	userDao.saveUser(user);
    	
    	return "redirect:list.html";
    }
	
	@RequestMapping(value="/user/add.html", method=RequestMethod.GET)
	public String add(ModelMap models){
		models.put("user", new User());
		return "user/add";
	}
	
	@RequestMapping(value="/user/add.html", method=RequestMethod.POST)
	public String add(@ModelAttribute User user){
		user = userDao.saveUser(user);
		return "redirect:list.html";
	}
	@RequestMapping(value="/user/edit.html", method=RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models){
		models.put("user",userDao.getUser(id));
		return "user/edit";
	}
	@RequestMapping(value="/user/edit.html", method=RequestMethod.POST)
	public String edit(@ModelAttribute User user, SessionStatus status){
		user = userDao.saveUser(user);
		status.setComplete();
		return "redirect:list.html";
	}
}
