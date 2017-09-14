package com.my.blog.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * author:13
 * date:2017-09-14
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }
}
