package com.inspur.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lvyue
 * @since: 2020/6/19
 * @version: 1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level frignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
