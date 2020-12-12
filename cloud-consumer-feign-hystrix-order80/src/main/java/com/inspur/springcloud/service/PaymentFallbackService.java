package com.inspur.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author lvyue
 * @since 2020/6/30
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "--PaymentFallbackService fall back--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--PaymentFallbackService fall back--paymentInfo_TimeOut";
    }
}
