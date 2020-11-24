package com.spring.second;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author dzl
 * 2020/11/18 9:14
 * @Description
 */
public class TimeHandler implements MethodBeforeAdvice, AfterReturningAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before----CurrentTime = " + System.currentTimeMillis());

    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after----CurrentTime = " + System.currentTimeMillis());
    }
}
