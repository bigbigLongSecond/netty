package com.shensiyuan.concurrency4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dzl
 * 2020/11/13 11:06
 * @Description 三个线程依次打印1-99个数字
 */
public class MyTest7 {
    public static void main(String[] args) {
        PrintHundred printHundred = new PrintHundred();
        new Thread(()->{
            printHundred.printNnm(printHundred.pre, printHundred.current);
        },"first").start();
        new Thread(()->{
            printHundred.printNnm(printHundred.current , printHundred.next);
        },"second").start();
        new Thread(()->{
            printHundred.printNnm(printHundred.next , printHundred.pre);
        },"third").start();
    }
}
class PrintHundred{
    private Lock lock = new ReentrantLock();
    public Condition pre = lock.newCondition();
    public Condition current = lock.newCondition();
    public Condition next = lock.newCondition();
    private int num = 0;

    public void prePrint(Condition pre ,Condition next ){
        lock.lock();
        try {
            while (num <99){
                System.out.println( Thread.currentThread().getName()+"  :" +num++);
                next.signal();
                pre.await();
            }
            next.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printNnm(Condition self, Condition next) {
        lock.lock();
        try {
            // 打印到99
            while (num < 99) {
                num += 1;
                System.out.println( Thread.currentThread().getName() + "  " + num);
                next.signal();
                self.await();
            }
            // 最后一个打印99结束也要唤醒下一个线程，保证下一个线程不在阻塞状态
            next.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
