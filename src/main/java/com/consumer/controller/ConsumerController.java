package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hi")
public class ConsumerController {

    @Resource
    HelloService helloService;

    @Autowired
    FeignService feignService;

    /**
     * http://localhost:9001/hi/hello?param=Hello%20World
     * 刷新上面地址，会切换不同的端口
     * @param param
     * @return
     */
    @GetMapping("/hello")
    public String helloConsumer( @RequestParam String param ) {
        return helloService.hello( param );
    }

    @RequestMapping("/consumer")
    public String helloConsumer(){
        return feignService.hello();
    }

    @RequestMapping("/consumer2")
    public String helloConsumer2(){
        String r1 = feignService.hello("Hi");
        String r2 = feignService.hello("Welcome", 23).toString();
        String r3 = feignService.hello(new User(new Integer(2),"Xiao Wang", 23));
        return r1 + "-----" + r2 + "----" + r3;
    }


}
