package com.example.serverribbon.controller;

import com.example.serverribbon.feign.FeignService;
import com.example.serverribbon.web.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private FeignService feignService;

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name = "+name);
        return helloService.hello(name);
    }

    @GetMapping("/feign-test")
    public String feignTest(String name){
        System.out.println("feign-test = "+name);
        return feignService.feignTest(name);
    }

}
