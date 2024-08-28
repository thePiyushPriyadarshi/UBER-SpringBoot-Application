package com.piyushpriyadarshi.uberApp.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public DefaultResponseClass defaultController(){
        DefaultResponseClass responseClass = new DefaultResponseClass();
        responseClass.setMessage("Server is up and Running");
        return responseClass;
    }
}

@Data
class DefaultResponseClass{
    private String message;
}
