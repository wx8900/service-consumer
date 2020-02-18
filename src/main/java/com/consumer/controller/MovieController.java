package com.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * http://localhost:9001/movie/findById/2
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private UserClientService userClientService;

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable Integer id) {
        String user = userClientService.getById(id);
        return user;
    }
}
