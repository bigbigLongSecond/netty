package com.thread;

import java.util.concurrent.*;

/**
 * @author dzl
 * 2020/11/3 9:33
 * @Description
 */
public class FutureExample {
    public static void main(String[] args) {
        FutureExample example =new FutureExample();
        example.example2();

        CompletableFuture
    }
    public void example1(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = () -> {
            System.out.println("callable thread running");
            Thread.sleep(4000);
            return "running";
        };
        Future<String> submit = executorService.submit(callable);
        System.out.println("main thread running");
        try {
            while (!submit.isDone()) {
                System.out.println("callable thread running");
                Thread.sleep(1000);
            }
            System.out.println("thread is close");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public void example2(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> callable1 = new ThreadTwo();
        Future<String> submit = executorService.submit(callable1);
        ThreadOne threadOne = new ThreadOne(submit);
        Future<String> submit1 = executorService.submit(threadOne);
        try {
            String s = submit1.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }

    }

    class ThreadOne implements Callable<String>{
        private Future<String> callable;

        public ThreadOne(Future<String> callable) {
            this.callable = callable;
        }

        @Override
        public String call() throws Exception {
            System.out.println("洗水壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("烧开水");
            TimeUnit.SECONDS.sleep(5);
            String s = callable.get();
            System.out.println(s);
            return "茶泡好了";
        }
    }
    class ThreadTwo implements Callable<String>{


        @Override
        public String call() throws Exception {
            System.out.println("洗茶壶");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("洗茶杯");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("拿茶叶");
            TimeUnit.SECONDS.sleep(1);
            return "茶叶好了";
        }
    }
}
