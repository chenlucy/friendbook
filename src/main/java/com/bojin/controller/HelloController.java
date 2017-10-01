package com.bojin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/10/1.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("find")
    public String find(){
        return "hello word!";
    }

}
