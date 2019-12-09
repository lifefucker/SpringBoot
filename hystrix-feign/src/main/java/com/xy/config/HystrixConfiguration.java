package com.xy.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 陆明宇 on 2019/11/28.
 *
 * @author 陆明宇
 * @version 1.0
 * @description HystrixConfiguration
 * @modify 陆明宇
 * @since 15:57
 */
@Configuration
public class HystrixConfiguration {
    @Bean
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }
}
