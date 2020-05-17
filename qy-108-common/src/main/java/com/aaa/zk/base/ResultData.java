package com.aaa.zk.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author zk
 * @Date 2020/5/12
 */
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;


}
