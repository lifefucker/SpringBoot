package com.xy.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 陆明宇 on 2019/12/9.
 *
 * @author 陆明宇
 * @version 1.0
 * @description FeignRequestInterceptor
 * @modify 陆明宇
 * @since 10:45
 */
@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignRequestInterceptor.class);

    @Override
    public void apply(RequestTemplate template) {
        LOGGER.info("[FeignRequestInterceptor-apply] visited!");
        Map<String,String> headers = getHeaders(getHttpServletRequest());
        LOGGER.info("[FeignRequestInterceptor-apply] Headers:{}!",headers);
        for(String headerName : headers.keySet()){
            template.header(headerName, getHeaders(getHttpServletRequest()).get(headerName));
        }
        LOGGER.info("[FeignRequestInterceptor-apply] Interceptor Success!");
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            LOGGER.info("[FeignRequestInterceptor-getHttpServletRequest] GetHttpServletRequest Failed!");
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new LinkedHashMap<>();
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }
}
