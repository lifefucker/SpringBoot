package com.xy.controller;

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

    @PostMapping("/test01")
    public Object test01(@RequestParam String param){
        return "success";
    }

    @GetMapping("/test02")
    public Object test02(@RequestParam String param){
        return "client2";
    }

}
