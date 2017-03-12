package formbuilder.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formbuilder.model.User;
import formbuilder.model.dao.UserDao;

@Controller
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
	public String editUser(ModelMap models, @RequestParam Integer id){
		models.put("user",userDao.getUser(id));
		return "user/view";
	}
	
}
