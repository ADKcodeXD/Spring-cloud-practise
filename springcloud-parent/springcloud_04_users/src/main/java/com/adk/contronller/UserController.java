package com.adk.contronller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private  DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;
    
    @GetMapping("user")
    public String Demouser() {
//        RestTemplate restTemplate;
//        restTemplate = new RestTemplate();
//        //调用订单服务的order服务
//        String forObject = restTemplate.getForObject("http://localhost:9999/order", String.class);

        //使用ribbon组件实现负载均衡调用
//        List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
//        String forObject = new RestTemplate().getForObject(orders.get(0).getUri()+ "/order", String.class);
        //使用loadBalancerClient
//        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDERS");
//        String forObject1 = new RestTemplate().getForObject(serviceInstance.getUri()+"/order", String.class);
        //使用注解
        String forObject = restTemplate.getForObject("http://ORDERS/order", String.class);
        System.out.println("调用成功" + forObject);
        return "user ok!!!1" + forObject + "调用成功";
    }

}
