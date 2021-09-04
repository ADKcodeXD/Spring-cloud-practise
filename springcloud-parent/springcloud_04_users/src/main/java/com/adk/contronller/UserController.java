package com.adk.contronller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("user")
    public String Demouser() {
        RestTemplate restTemplate;
        restTemplate = new RestTemplate();
        //调用订单服务的order服务
        String forObject = restTemplate.getForObject("http://localhost:9999/order", String.class);
        System.out.println("调用成功" + forObject);
        return "user ok!!!1" + forObject + "调用成功";
    }
    
}
