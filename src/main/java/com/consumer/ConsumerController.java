package com.consumer;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    HelloService helloService;

    @GetMapping("/hello")
    public String helloConsumer( @RequestParam String param ) {
        return helloService.hello( param );
    }

}
