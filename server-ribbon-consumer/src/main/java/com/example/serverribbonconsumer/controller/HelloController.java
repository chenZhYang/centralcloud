package com.example.serverribbonconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaronchen on 2019/4/22
 *
 * @author Aaronchen
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name = "+name);
        return "I AM "+name;
    }

    @RequestMapping(value = "/feign-test")
    public String feignTest(@RequestBody String name){
        System.out.println("feign-test = "+name);
        return "feign-test "+name;
    }
}
