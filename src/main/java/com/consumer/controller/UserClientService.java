package com.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider")
public interface UserClientService {

    @GetMapping("/user/getById/{id}")
    public String getById(@PathVariable("id") Integer id);
}
