package com.inspur.springcloud.controller;

import com.inspur.springcloud.entities.CommonResult;
import com.inspur.springcloud.entities.Payment;
import com.inspur.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: lvyue
 * @Date: 2020/6/17
 * @Description: com.inspur.springcloud.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon，客户端一致默认等待1秒钟。
        return paymentFeignService.paymentFeignTimeout();
    }


}
