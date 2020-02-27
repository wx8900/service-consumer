package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jack
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getOrder")
    public String getOrder() {
        String url = "http://eureka-7001.com:7001/getUser";
        //String url = "http://eureka-7001.com:7001/eureka/getUser";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("订单服务调用用户服务result ： " + result );
        return result;
    }
}
