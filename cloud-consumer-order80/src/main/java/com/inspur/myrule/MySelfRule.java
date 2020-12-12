package com.inspur.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author: lvyue
 * @Date: 2020/6/15
 * @Description: com.inspur.myrule
 * @version: 1.0
 */
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
