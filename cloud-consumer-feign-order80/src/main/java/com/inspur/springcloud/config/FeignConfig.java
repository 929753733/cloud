package com.inspur.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author: lvyue
 * @since: 2020/6/19
 * @version: 1.0
 */
public class FeignConfig {

    @Bean
    Logger.Level frignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
