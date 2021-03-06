package com.thread;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 14:01
 * 2000
 */
public class AtomicTest {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        System.out.println("默认值"+atomicBoolean.get());
        atomicBoolean.set(false);
        System.out.println("修改后的值" + atomicBoolean.get());
        Boolean oldValue = atomicBoolean.getAndSet(true);
        System.out.println("getOld" + oldValue );
        System.out.println("getNew " + atomicBoolean.get());
        boolean expectedValue = true;
        boolean newValue = false;
        AtomicInteger atomicInteger = new AtomicInteger(10);
        int i = atomicInteger.incrementAndGet();
        int i1 = atomicInteger.addAndGet(4);
        System.out.println(i1);

        boolean value = atomicBoolean.compareAndSet(expectedValue, newValue);
        System.out.println("compareAndSet后返回的值："+value);
        System.out.println("atomicBoolean现在的值为："+atomicBoolean.get());
    }
}
