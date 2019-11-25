package com.xy.controller;

import com.xy.remote.PromotionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //这里直接注入feign client
    @Autowired
    private PromotionClient promotionClient;

    @PostMapping("/testFeign")
    public Object testFeign(@RequestParam String param){
        return promotionClient.testFeign(param);
    }

}