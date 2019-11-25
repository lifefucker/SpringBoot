package com.xy.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 陆明宇 on 2019/11/25.
 *
 * @author 陆明宇
 * @version 1.0
 * @description PromotionClient
 * @modify 陆明宇
 * @since 16:46
 */
@FeignClient(value = "EUREKA-CLIENT")
public interface PromotionClient {

    @GetMapping("/test/test02")
    String testFeign(@RequestParam String param);
}
