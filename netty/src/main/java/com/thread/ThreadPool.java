package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author dzl
 * 2020/11/2 9:06
 * @Description
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
        Thread thread = new Thread(() -> {
            System.out.println("hello");
        });
        threadPoolExecutor.submit(thread);
        Lock lock = new ReentrantLock();
        ReadWriteLock lock1 = new ReentrantReadWriteLock();
    }
}
