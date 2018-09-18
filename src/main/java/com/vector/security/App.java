package com.vector.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: vector.huang
 * date: 2018/09/18 17:39
 */
@RestController
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("/user/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/public/hello")
    public String hello2(){
        return "hello";
    }


    @GetMapping("/custom/hello")
    public String hello3(){
        return "hello";
    }

}
