package com.thread;

/**
 * @author dzl
 * 2020/10/27 15:07
 * @Description
 */
public class Client {


    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.test();
    }

    private int number = 0;

    private void read() {
        System.out.print("number = "+ number);
    }

    private synchronized void write(int change) {
        number += change;
    }

    public void test() throws InterruptedException {
        // 开启一个线程加 10000 次
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                write(1);
            }
            System.out.println("增加 100000 次已完成");
        }).start();

        /* 开启一个线程减 10000 次 */
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                read();
            }
            System.out.print("减少 100000 次已完成");
        }).start();

        // 睡眠一秒保证线程执行完成
        Thread.sleep(1000);
        // 读取结果
        read();
    }
}
