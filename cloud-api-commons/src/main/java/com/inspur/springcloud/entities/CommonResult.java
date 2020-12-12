package com.inspur.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lvyue
 * @Date: 2020/5/25
 * @Description: com.inspur.springcloud.entities
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;
    
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
