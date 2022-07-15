package com.example.serverribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaronchen on 2019/4/22
 *
 * @author Aaronchen
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name = "+name);
        return "I AM "+ name + ", port = " + port;
    }

    @RequestMapping(value = "/feign-test")
    public String feignTest(@RequestParam("name") String name){
        System.out.println("feign-test = "+name);
        return "feign-test = "+name + ", port = " + port;
    }

    /**
     * 测试负载均衡
     */
    @GetMapping("/test-load-balance")
    public String testLoadBalance(){
        System.out.println("hystrix-test");
        try {
            if (! port.equalsIgnoreCase("8764")) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/hystrix-test")
    public String hystrixTest(@RequestParam("name") String name){
        System.out.println("hystrix-test = "+name);
        try {
            if (! port.equalsIgnoreCase("8764")) {
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hystrix-test = "+name + ", port = " + port;
    }
}
