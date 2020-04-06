package com.tw.restdemo.controller;

import com.tw.restdemo.model.Greeting;
import com.tw.restdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    Greeting greeting;

    @GetMapping("/hello")
    public String hello(){
        return "Welcome to spring boot!";
    }

    @GetMapping("/helloName")
    public String hello(@RequestParam(value = "name", defaultValue = "Unknown") String name){
        return "Welcome to spring boot, " + name;
    }

    @GetMapping("/helloUser")
    public String hello(@RequestBody User user){
        return "Welcome to spring boot, " + user.getName();
    }

    @GetMapping("/helloUserGreeting")
    public @ResponseBody Greeting helloGreeting(@RequestBody User user){
        Greeting greeting = new Greeting();
        greeting.setContent("Welcome, " + user.getName());
        return greeting;
    }

    @PostMapping("/greeting")
    public String createGreeting(@RequestParam(value = "message", defaultValue = "UNKNOWN") String message) {
        greeting.setCustomMessage(message);
        return "SUCCESS!!";
    }

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting.getContent();
    }
}
