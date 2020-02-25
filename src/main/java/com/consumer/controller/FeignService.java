package com.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * configuration = xxx.class  这个类配置Hystrix的一些精确属性, value=“你用到的服务名称”
 */
@FeignClient(value = "service-provider")
public interface FeignService {

    // 服务中方法的映射路径
    @RequestMapping("/hello")
    String hello();

    /**
     * http://localhost:9001/hellol?name=test
     * @param name
     * @return
     */
    @RequestMapping(value = "/hellol", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;

    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method= RequestMethod.POST)
    String hello(@RequestBody HelloUser user);
}
