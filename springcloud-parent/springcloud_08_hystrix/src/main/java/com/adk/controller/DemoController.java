package com.adk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("demo")
    @HystrixCommand(fallbackMethod = "demoFallBack")
    public String demo(@RequestParam("id") Integer id){
        System.out.println("demo ok");
        if(id<0){
            throw new RuntimeException("无效id");
        }
        return "demo ok";
    }

    public String demoFallBack(@RequestParam("id") Integer id){
        return "当前服务已被熔断";
    }
}
