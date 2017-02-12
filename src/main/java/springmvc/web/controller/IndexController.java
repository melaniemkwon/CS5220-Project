// For testing project setup http://csns.calstatela.edu/wiki/content/cysun/course_materials/cs520/sham/spring
// Check if it works at the URL http://localhost:8080/springmvc/ or http://localhost:8080/springmvc/index.html.

package springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index.html")
    public String index()
    {
        return "index";
    }

}