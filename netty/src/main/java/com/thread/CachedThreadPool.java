package com.thread;

import java.util.concurrent.*;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 10:21
 */
public class CachedThreadPool {

    /**
     * @param args
     */
    public static void main(String[] args) {

        class MyRunnable implements Runnable{
            private int a = 5;
            @Override
            public void run() {
                synchronized(this){
                    for(int i=0;i<10;i++){
                        if(this.a>0){
                            System.out.println(Thread.currentThread().getName()+" a的值:"+this.a--);
                        }

                    }
                }
            }
        }

        MyRunnable myRunnable = new MyRunnable();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(myRunnable);

        }
        executorService.shutdown();
        System.out.println("hello");

//        int i = 0;
//        for (;;){
//            if (i >20){
//                return;
//            }
//            if (i==10){
//                break;
//            }
//            if (i==9){
//                System.out.println("continue");
//                continue;
//            }
//            System.out.println("hell" + i++);
//        }

    }

}

