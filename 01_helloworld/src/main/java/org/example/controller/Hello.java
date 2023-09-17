package org.example.controller;

import org.example.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JX
 * @ClassName: org.example.controller.Hello
 * @Create 2023-09-17 14:45
 * @Description: TODO
 */
//@ResponseBody //返回字符串，不是一个网页
//@Controller

@RestController
public class Hello {
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello,springboot 2";


    }

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }
}
