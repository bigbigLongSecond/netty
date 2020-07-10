package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 13:46
 */
public class LockAndUnLock {

    static Lock lock = new ReentrantLock();//新建锁

    public static void main(String[] args) {


        new Thread("A"){
            @Override
            public void run() {
                Thread.yield();//当前线程的让步，加快线程切换
                numPrint();

            };
        }.start();

        new Thread("B"){
            @Override
            public void run() {
                Thread.yield();//当前线程的让步，加快线程切换
                numPrint();
            };
        }.start();

    }

    private static void numPrint(){
        lock.lock();
        try{
            for(int i=0;i<10;i++){
                Thread.sleep(100);
                System.out.println("当前线程"+Thread.currentThread().getName()+"："+i);
            }
        }catch(Exception e){

        }finally{
            lock.unlock();
        }
    }

}

