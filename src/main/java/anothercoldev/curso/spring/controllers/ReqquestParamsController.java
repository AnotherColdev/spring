package anothercoldev.curso.spring.controllers;

import org.springframework.web.bind.annotation.RestController;

import anothercoldev.curso.spring.models.dto.ParamDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class ReqquestParamsController {

    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "Oops, que haces aqui?") String message) {
        ParamDTO param = new ParamDTO();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamDTO bar(@RequestParam(required = true) String text, @RequestParam Integer code) {
        ParamDTO params = new ParamDTO();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }
}
