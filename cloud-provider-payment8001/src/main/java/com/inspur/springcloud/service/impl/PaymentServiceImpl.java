package com.inspur.springcloud.service.impl;

import com.inspur.springcloud.dao.PaymentDao;
import com.inspur.springcloud.entities.Payment;
import com.inspur.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lvyue
 * @Date: 2020/5/25
 * @Description: com.inspur.springcloud.service.impl
 * @version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
