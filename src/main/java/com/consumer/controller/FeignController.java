package com.consumer.controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
public class FeignController {

    @Resource
    FeignService feignService;

    /**
     * http://localhost:9001/hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println(feignService.hello() + "访问来1了......");
        return "hello1";
    }

    /**
     * http://localhost:9001/hjcs
     * @param ids
     * @return
     */
    @RequestMapping("/hjcs")
    public List<String> laowangs(String ids){
        List<String> list = new ArrayList<>();
        list.add("laowang1");
        list.add("laowang2");
        list.add("laowang3");
        return list;
    }

    /**
     * http://localhost:9001/hello1?name=Liu
     * Hello Liu
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello1", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    /**
     * http://localhost:9001/hello2?name=Liu&age=18
     * User{id=1, name='Liu', age=18}
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    public String hello(@RequestParam String name, @RequestParam Integer age) {
        return new User(new Integer(1), name, age).toString();
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello (@RequestBody User user) {
        return "Hello "+ user. getName () + ", " + user. getAge ();
    }

}
