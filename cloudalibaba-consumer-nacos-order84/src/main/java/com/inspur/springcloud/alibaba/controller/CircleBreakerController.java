package com.inspur.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.inspur.springcloud.alibaba.service.PaymentService;
import com.inspur.springcloud.entities.CommonResult;
import com.inspur.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lvyue
 * @since 2020/12/22
 */
@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")// fallback只负责业务异常，如果有程序运行异常，则执行handlerFallback方法。
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")// blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})
// 如果报IllegalArgumentException，不再进行服务降级，将之前的异常抛出。
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException，空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback，exception内容" + e.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment();
        return new CommonResult(445, "blockHandler-sentinel限流，无此流水，exception内容" + blockException.getMessage(), payment);
    }


    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }


}
