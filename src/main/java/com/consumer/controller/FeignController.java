package com.consumer.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@RestController
public class FeignController {

    /**
     * http://localhost:9001/hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("访问来1了......");
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
     * http://localhost:9001/hellol?name=Liu
     * @param name
     * @return
     */
    @RequestMapping(value = "/hellol", method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/hello2", method= RequestMethod.GET)
    public HelloUser hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new HelloUser(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello (@RequestBody HelloUser user) {
        return "Hello "+ user. getName () + ", " + user. getAge ();
    }

}
