package com.inspur.springcloud.alibaba.service;

import com.inspur.springcloud.entities.CommonResult;
import com.inspur.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author lvyue
 * @since 2020/12/22
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回，----PaymentFallbackService", new Payment(id, "errorserial"));
    }
}
