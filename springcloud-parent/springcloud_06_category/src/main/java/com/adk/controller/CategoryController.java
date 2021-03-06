package com.adk.controller;


import com.adk.entity.Product;
import com.adk.feignclient.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class CategoryController {

    @Value("${server.port}")
    private int port;
    @Autowired
    private ProductClient productClient;

    @GetMapping("category")
    public List<Product> category(){
        System.out.println("category............");
//        String product = productClient.product();
//        String test=productClient.test("xiaocheng",23);
//        String test1 = productClient.test1(123, "dsduoia");
//        String wocao = productClient.test2(new Product(123, "wocao", new Date()));
//        String s = productClient.test3(new String[]{"123", "46", "4984"});
        List<Product> byCategoryId = productClient.findByCategoryId(1);
        System.out.println("====================");
//        System.out.println(product);
//        System.out.println(test);
//        System.out.println(test1);
//        System.out.println(wocao);
//        System.out.println(s);
        for (Product product : byCategoryId) {
            System.out.println(product);
        }
        System.out.println("====================");
        return byCategoryId;
    }
}
