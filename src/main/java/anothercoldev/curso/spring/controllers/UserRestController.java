package anothercoldev.curso.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import anothercoldev.curso.spring.models.User;
import anothercoldev.curso.spring.models.dto.UserDTO;


@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @GetMapping("/details")
    public UserDTO detailsRest() {
        User user = new User("Carlos", "Gutierrez");

        UserDTO userDTO = new UserDTO();
        userDTO.setUser(user);
        userDTO.setTitle("Hola Mundo SpringDTO");

        return userDTO;
    }


    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Carlos", "Gutierrez");
        User user2 = new User("Pepe", "Ramirez");
        User user3 = new User("Diego", "Lopez");
        User user4 = new User("Alonso", "Zavaleta");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        return users;
    }

    @GetMapping("/details-rest2")
    public Map<String, Object> detailsRest2() {
        User user = new User("Carlos", "Gutierrez");
        Map  <String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Springboot API");
        body.put("user", user);
        return body;
    }

}
