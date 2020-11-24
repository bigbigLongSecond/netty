package com.shensiyuan.concurrency4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dzl
 * 2020/11/13 10:41
 * @Description 两个线程依赖打印0和1
 */
public class MyTest6 {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
       new Thread(()->{
           for (int i = 0; i < 100; i++) {
               printNum.increase();
               try {
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
       new Thread(()->{
           for (int i = 0; i < 100; i++) {
               printNum.decrease();
               try {
                   Thread.sleep(200);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
}
class PrintNum{
    private Lock lock = new ReentrantLock();
    private Condition increase = lock.newCondition();
    private int value;

    public void increase(){
        lock.lock();
        try {
            while (value != 0)
                increase.await();
            System.out.println(++value);
            increase.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrease(){
        lock.lock();
        try {
            while (value == 0){
                increase.await();
            }
            System.out.println(--value);
            increase.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
