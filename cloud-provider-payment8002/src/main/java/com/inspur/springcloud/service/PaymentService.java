package com.inspur.springcloud.service;

import com.inspur.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: lvyue
 * @Date: 2020/5/25
 * @Description: com.inspur.springcloud.service
 * @version: 1.0
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
