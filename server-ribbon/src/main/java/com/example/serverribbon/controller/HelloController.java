package com.example.serverribbon.controller;

import com.example.serverribbon.web.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaronchen on 2019/4/22
 *
 * @author Aaronchen
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name = "+name);
        return helloService.hello(name);
    }


}
