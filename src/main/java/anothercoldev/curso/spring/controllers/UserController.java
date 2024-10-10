package anothercoldev.curso.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import anothercoldev.curso.spring.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String dettails(Model model) {
        User user = new User("Carlos", "Gutierrez", "");
        model.addAttribute("title", "Hola Spring desde el controlador");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Listado de usuarios con thymeleaf");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel() {
        List<User> users = new ArrayList<>();

        users.add(new User("Carlos", "Gutierrez", "cagu@anothercoldev.com"));
        users.add(new User("Pepe", "Ramirez", "pera@anothercoldev.com"));
        users.add(new User("Diego", "Lopez", "dilo@anothercoldev.com"));
        users.add(new User("Alonso", "Zavaleta", "alza@anothercoldev.com"));
        return users;
    }
    
}
