package com.my.blog.springboot.thymeleaf.util;

/**
 * Created by 13 on 2017/9/14.
 */
public class MethodTest {
    public static String test() {
        return "thymeleaf调用java方法成功!";
    }

    public static long getTime() {
        return System.currentTimeMillis();
    }
}
