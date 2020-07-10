package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 9:58
 */
public class FirstThread {
    public static void main(String[] args) {
        class MyRunning implements Runnable {
            int ticket = 15;

            public  void run() {

                for (int i = 0; i < 20; i++) {
                    if (this.ticket > 0) {
                        System.out.println(Thread.currentThread().getName() + " 卖票：ticket " + this.ticket--);
                    }
                }

            }

        }
        MyRunning running = new MyRunning();
//        Thread thread1 = new Thread(running);
//        Thread thread2 = new Thread(running);
//        Thread thread3 = new Thread(running);
//        thread1.start();
//        thread2.start();
//        thread3.start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(running);
        }
        executorService.shutdown();

    }
}
