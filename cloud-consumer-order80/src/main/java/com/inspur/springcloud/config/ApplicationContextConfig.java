package com.inspur.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: lvyue
 * @Date: 2020/5/26
 * @Description: com.inspur.springcloud.config
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    /**
    * 使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
    */
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
