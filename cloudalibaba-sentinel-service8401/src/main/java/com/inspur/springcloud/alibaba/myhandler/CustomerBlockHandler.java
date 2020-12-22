package com.inspur.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.inspur.springcloud.entities.CommonResult;
import com.inspur.springcloud.entities.Payment;

/**
 * @author lvyue
 * @since 2020/12/22
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global----2");
    }
}
