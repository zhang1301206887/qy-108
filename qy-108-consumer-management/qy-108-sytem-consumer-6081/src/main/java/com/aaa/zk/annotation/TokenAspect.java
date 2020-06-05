package com.aaa.zk.annotation;/*
 *@Company：
 *@Author：何康
 *@Date：2020/6/5 11:12
 *@Description:
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class TokenAspect {

    @Pointcut("@annotation(com.aaa.zk.annotation.TokenAnnotation)")
    public void pointcut() {

    }
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws ClassNotFoundException {
        return null;
    }
}
