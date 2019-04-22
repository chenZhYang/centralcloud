package com.example.serverribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Aaronchen on 2019/4/22
 *
 * @author Aaronchen
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hello(String name){
        System.out.println("http://server-ribbon-consumer/hello?name="+name);
        return restTemplate.getForObject("http://server-ribbon-consumer/hello?name="+name,String.class);
    }
}
