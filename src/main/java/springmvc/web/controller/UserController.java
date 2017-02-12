// To test project setup. http://csns.calstatela.edu/wiki/content/cysun/course_materials/cs520/sham/hibernate

package springmvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springmvc.model.dao.UserDao;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/users.html")
    public String users( ModelMap models )
    {
        models.put( "users", userDao.getUsers() );
        return "users";
    }

}