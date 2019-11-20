package com.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 陆明宇 on 2019/11/20.
 *
 * @author 陆明宇
 * @version 1.0
 * @description TestController
 * @modify 陆明宇
 * @since 15:38
 */
@RestController
@RequestMapping("/test")

public class TestController {

    //这里注入的restTemplate就是在com.sam.ConsumerApp中通过@Bean配置的实例
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testConsumer")
    public Object testConsumer(@RequestParam String param){
        //调用hello-service服务，注意这里用的是服务名，而不是具体的ip+port
        String res = restTemplate.getForObject("http://EUREKA-CLIENT/test/test02?param={?}",
                String.class,
                "testConsumerParams");
        return res;
    }

}
