package com.adk.feignclient;

import com.adk.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调用商品服务的接口
 * 调用的服务不同，名字也相应不同
 */
@FeignClient("PRODUCT")
public interface ProductClient {

    /**
     * 接口的形式要和服务方的方法一样
     * @return
     */
    @GetMapping("product")
    String product();

    /**
     * 零散参数的传递
     * @param name
     * @param age
     * @return
     */
    @GetMapping("test")
    String test(@RequestParam("name") String name,@RequestParam("age") Integer age);

    @GetMapping("test1/{id}/{name}")
    String test1(@PathVariable("id") Integer id,@PathVariable("name") String name);

    @PostMapping("/test2")
    String test2(@RequestBody Product product);

    @GetMapping("/test3")
    public String test3(@RequestParam("ids") String[] ids);

    @GetMapping("/product/{id}")
    Product productid(@PathVariable("id") Integer id);

    @GetMapping("/products")
    List<Product> findByCategoryId(@RequestParam("categoryid")Integer categoryid);

}
