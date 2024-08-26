package com.piyushpriyadarshi.uberApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity<String> defaultController(){
        return ResponseEntity.ok("Server is up and running");
    }
}
