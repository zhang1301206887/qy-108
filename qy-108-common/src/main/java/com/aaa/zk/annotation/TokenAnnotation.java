package com.aaa.zk.annotation;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/5 11:02
 *@Description:
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenAnnotation {

    String operationType() default "";


    String operationName() default "";
}
