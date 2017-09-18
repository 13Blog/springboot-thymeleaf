package com.my.blog.springboot.thymeleaf.controller;

import com.my.blog.springboot.thymeleaf.util.MethodTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 13 on 2017/9/14.
 */
@Controller
public class MethodTestController {

    @RequestMapping("/test1")
    public String test1(HttpServletRequest request) {
        return "test";
    }

    @RequestMapping("/test2")
    public String test2(HttpServletRequest request) {
        request.setAttribute("MethodTest", new MethodTest());
        return "test";
    }

    @RequestMapping("/test3")
    public String test3(HttpServletRequest request) {
        request.setAttribute("MethodTest", new MethodTest());
        return "test3";
    }

}
