package com.adk.controller;

import com.adk.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Value("${server.port}")
    private int port;

    @GetMapping("product")
    public String product(){
        System.out.println("product............");
        return "进入商品服务，"+port;
    }

    @GetMapping("test")
    public String test(@RequestParam("name") String name, @RequestParam("age") Integer age){
        System.out.println(name+age);
        return "test ok"+port;
    }

    @GetMapping("test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id, @PathVariable("name") String name){
        return "id:"+id+"name"+name+port;
    }

    @PostMapping("test2")
    public String test2(@RequestBody Product product){
        return "test2ok"+port+"product:"+product;
    }
}
