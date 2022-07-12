package com.example.serverribbon.controller;

import com.example.serverribbon.feign.FeignService;
import com.example.serverribbon.web.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaronchen on 2019/4/22
 *
 * @author Aaronchen
 */
@RestController
public class HelloController {

    private final HelloService helloService;

    private final FeignService feignService;

    @Autowired
    public HelloController(HelloService helloService, FeignService feignService) {
        this.helloService = helloService;
        this.feignService = feignService;
    }

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

    /**
     * 测试负载均衡
     * @param num 访问次数
     * @return
     */
    @GetMapping("/test-load-balance")
    public Map<String, Integer> testLoadBalance(Integer num){
        System.out.println("test-load-balance = "+num);
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i=0; i<num; i++) {
            String port = feignService.testLoadBalance();
            if (resultMap.containsKey(port)) {
                Integer visitNum = resultMap.get(port);
                visitNum ++;
                resultMap.put(port, visitNum);
            } else {
                resultMap.put(port, 1);
            }
        }
        return resultMap;
    }
}
