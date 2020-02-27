package com.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * http://localhost:9001/consumer/date?param=www.codesheep.cn
 * test www.codesheep.cn, Port is : 8002
 */
@RestController
@RequestMapping("/consumer")
public class DateServiceFeignController {

    @Resource
    DateServiceFeignClientInterface dateServiceFeignClientInterface;

    @GetMapping("/date")
    public String getDate( @RequestParam String param ) {
        return dateServiceFeignClientInterface.consumer( param );
    }
}
