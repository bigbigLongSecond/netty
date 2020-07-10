package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author dzl
 * 2020/4/16 9:20
 * @Description
 */
public class TreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);



        for (int i = 0; i < 1000; i++) {
            executorService2.execute(()-> {
                System.out.println(Thread.currentThread().getName());
            });
            
        }

    }
}
