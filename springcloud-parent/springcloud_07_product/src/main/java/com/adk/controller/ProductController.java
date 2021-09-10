package com.adk.controller;

import com.adk.entity.Product;
import com.adk.vo.CollectionVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @GetMapping("test3")
    public String test3(CollectionVo collectionVo){
       collectionVo.getIds().forEach(id-> System.out.println(id));

        return "调用list成功" ;

    }

    @GetMapping("/product/{id}")
    public Product productid(@PathVariable("id") Integer id){
        System.out.println("id:"+id);
        return new Product(id,"huiah",new Date());
    }

    @GetMapping("/products")
    public List<Product> findByCategoryId(@RequestParam("categoryid") Integer categoryid){
        System.out.println(categoryid);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1,"hdsoiuahdo",new Date()));
        products.add(new Product(2,"sjdioa",new Date()));
        products.add(new Product(3,"husai",new Date()));
        return products;
    }
}
