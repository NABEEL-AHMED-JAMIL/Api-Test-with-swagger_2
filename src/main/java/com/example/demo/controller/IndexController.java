package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nabeel on 9/24/2017.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(method= RequestMethod.GET)
    String index(){
        return "index";
    }
}