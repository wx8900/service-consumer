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
     * http://localhost:9001/hi/hello?param=Good
     * hello Good, port is : 8001
     * 刷新上面地址，会切换不同的端口
     * @param param
     * @return
     */
    @GetMapping("/hello")
    public String helloConsumer( @RequestParam String param ) {
        return helloService.hello( param );
    }

    /**
     * http://localhost:9001/hi/consumer?param=Mr. Zhao
     * Mr. Zhao，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8002, 当前日期是 公元 2020年02月27号 星期四 下午 11时06分35秒
     * Mr. Zhao，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8001, 当前日期是 公元 2020年02月27号 星期四 下午 11时07分21秒
     * @return
     */
    @RequestMapping("/consumer")
    public String helloUser( @RequestParam String param ){
        return feignService.hello(param);
    }

    /**
     * http://localhost:9001/hi/consumer2?param=Mr. Wang
     * Hi，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8001, 当前日期是 公元 2020年02月27号 星期四 下午 11时49分51秒
     * -----Mr. Wang，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8002, 当前日期是 公元 2020年02月27号 星期四 下午 11时49分51秒
     * -----Xiao Wang，您好，您的年龄是 ： 23
     *
     * Hi，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8002, 当前日期是 公元 2020年02月27号 星期四 下午 11时57分20秒
     * -----Mr. Wang，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8001, 当前日期是 公元 2020年02月27号 星期四 下午 11时57分20秒
     * -----Xiao Wang，您好，您的年龄是 ： 23
     * @return
     */
    @RequestMapping("/consumer2")
    public String helloConsumer2(@RequestParam String param){
        String r1 = feignService.hello("Hi");
        String r2 = feignService.hello(param);
        String r3 = feignService.hello("Xiao Wang", 23);
        return r1 + "-----" + r2 + "-----" + r3;
    }

    /**
     * http://localhost:9001/hi/consumer3?name=Mr.%20Wang&age=25
     * Hi Mr. Wang，您好，您的年龄是 ： 28
     * -----，您好，您是VIP用户，享受VIP专属服务！你的端口号是 ： 8001, 当前日期是 公元 2020年02月27号 星期四 下午 11时54分09秒
     * @return
     */
    @RequestMapping("/consumer3")
    public String helloConsumer3(@RequestParam String name, @RequestParam Integer age){
        String r1 = feignService.hello("Hi " + name, age);
        String r2 = feignService.hello("");
        return r1 + "-----" + r2;
    }


}
