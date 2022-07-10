package com.example.serverribbon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("server-ribbon-consumer")
public interface FeignService {

    @RequestMapping(value = "/feign-test")
    String feignTest(@RequestBody String name);
}
