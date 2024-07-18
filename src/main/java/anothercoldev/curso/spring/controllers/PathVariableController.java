package anothercoldev.curso.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anothercoldev.curso.spring.models.User;
import anothercoldev.curso.spring.models.dto.ParamDTO;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    
    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    @Value("${config.code}")
    private Integer code;
    
    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valueList;
    
    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private String price;
    

    //PathVariable con un solo parámetro en la ruta
    @GetMapping("/baz/{message}")
    public ParamDTO baz(@PathVariable String message) {

        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }

    //PathVariable con varios parámetros en la ruta
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }
    
    //Peticiones POST mediante postman (O cualquier aplicaci[on pero estoy usando Postman])
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueMap", valuesMap);
        json.put("product", product);
        json.put("price", price);

        return json;
    }
    

}