package com.example.serverribbon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "server-ribbon-consumer")
public interface FeignService {

    @RequestMapping(value = "/feign-test")
    String feignTest(@RequestParam("name") String name);

    @RequestMapping(value = "/test-load-balance")
    String testLoadBalance();

    @RequestMapping(value = "/hystrix-test")
    String hystrixTest(@RequestParam("name") String name);
}
