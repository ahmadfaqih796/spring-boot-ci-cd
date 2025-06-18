package com.example.java_hello_world_cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

   @GetMapping("/hello")
   public String sayHello() {
      return "Hello World! Welcome to CI/CD!";
   }

   @GetMapping("/hello2")
   public String sayHello2() {
      return "Hello World! Welcome to CI/CD 2";
   }
   
}
