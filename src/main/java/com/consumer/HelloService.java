package com.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-service")
public interface HelloService {

    @RequestMapping(value = "hello")
    String hello();
}
