package com.aaa.zk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author zk
 * @Date 2020/5/27
 *
 * 自定义注解
 *        实现自定义注解必须要添加两个注解:
 *            1.@Target:标识了该注解所使用的位置(所使用的范围)
 *                TYPE:作用于类
 *                METHOD:作用于方法
 *                FIELD:作用于属性
 *            2.Retention:标识了该注解什么时候生效
 *                RUNTIME:项目运行时生效
 *                TEST:测试阶段生效
 *                ...
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginLogAnnotation {

    /**
    * @author zk
    * @Date
    * 需要执行的操作类型      delete  login   register注册
     *
    */
    String operationType() default "";

    /**
    * @author zk
    * @Date
    *  执行的具体操作内容  如删除用户 删除图书等
    */
    String operationName() default "";



}
