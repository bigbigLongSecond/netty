package com.shensiyuan.concurrency4;

import java.io.InputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author dzl
 * 2020/11/13 10:03
 * @Description
 */
public class MyTest5 {
    public static void main(String[] args) {
        CountThread countThread = new CountThread();
        IntStream.range(0, 10).forEach(value -> new Thread(() -> {
            countThread.put(value);
        }).start());
        IntStream.range(0, 10).forEach(value -> new Thread(() -> {
            try {
                int take = countThread.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
    }
}

class CountThread {
    private Lock lock = new ReentrantLock();
    private Condition canPut = lock.newCondition();
    private Condition canTake = lock.newCondition();
    private int[] array = new int[10];
    private int count, putIndex, takeIndex;

    public void put(int element) {
        lock.lock();
        try {
            while (count == array.length) {
                canPut.await();
            }
            array[putIndex++] = element;
            if (putIndex == array.length) putIndex = 0;
            System.out.println("put value--->" + element);
            ++count;
            canTake.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                canTake.await();
            }
            int i = array[takeIndex++];
            System.out.println("take value--->" + i);
            if (takeIndex == array.length) takeIndex = 0;
            count--;
            canPut.signal();
            return i;
        } finally {
            lock.unlock();
        }
    }

}

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}