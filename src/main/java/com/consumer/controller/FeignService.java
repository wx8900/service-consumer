package com.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * configuration = xxx.class  这个类配置Hystrix的一些精确属性, value=“你用到的服务名称”
 */
@FeignClient(value = "service-provider")
public interface FeignService {

    // 服务中方法的映射路径

    @RequestMapping(value = "/getUser", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;

    @RequestMapping(value = "/getUserInfo", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping(value = "/getUser", method= RequestMethod.POST)
    String hello(@RequestBody User user);
}
