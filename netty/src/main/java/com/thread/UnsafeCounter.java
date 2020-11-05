package com.thread;

/**
 * @author dzl
 * 2020/10/29 14:35
 * @Description
 */
public class UnsafeCounter {

    private static int count;

    public static void main(String[] args) {
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        Thread thread = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                unsafeCounter.counter();
            }
        },"第一个count");
        Thread thread1 = new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                calc();
            }
        },"第er个count");
        thread.start();
        thread1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

    public synchronized void counter(){
        count++;
    }

    public static synchronized int calc(){
        return count--;
    }
}
