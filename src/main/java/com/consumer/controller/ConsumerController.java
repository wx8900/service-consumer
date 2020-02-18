package com.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class ConsumerController {

    @Resource
    HelloService helloService;

    @GetMapping("/hi")
    public String helloConsumer( @RequestParam String param ) {
        return helloService.hello( param );
    }

}
