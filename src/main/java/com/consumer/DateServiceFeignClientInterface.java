package com.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider")
public interface DateServiceFeignClientInterface {

    @GetMapping("/test")
    String consumer( @RequestParam("param") String param );
}
