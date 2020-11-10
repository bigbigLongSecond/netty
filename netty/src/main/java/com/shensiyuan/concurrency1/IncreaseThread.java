package com.shensiyuan.concurrency1;

public class IncreaseThread extends Thread {

    private MyObject myObject;

    public IncreaseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; ++i) {
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            myObject.increase();
        }
    }
}
