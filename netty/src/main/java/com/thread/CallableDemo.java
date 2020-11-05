package com.thread;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/1/8 13:36
 */
public class CallableDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {


        class TaskWithResult implements Callable<String> {

            private int id;
            public TaskWithResult(int id){
                this.id = id;
            }
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);

                return "result of Callable "+id;
            }

        }

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>>  results = new ArrayList<Future<String>>();
        for(int i=0;i<5;i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        System.out.println("HelloWorld");

        for(Future<String> fs:results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                exec.shutdown();
            }
        }
    }

}

