package test;

public class ThreadTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        class MyThread extends Thread{
            private volatile int ticket = 10;
            public  void run(){
                    for(int i=0;i<20;i++){
                        if(this.ticket>0){
                            System.out.println(this.getName()+"买票：ticket "+this.ticket--);
                        }
                    }               
            }
        }

        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        // 和上面的结果对比，并揣摩 “Runnable还可以用于“资源共享”。即，多个线程都是基于某个Runnable对象建立的，它们会共享Runnable对象上的资源”这句话。
        MyThread t1 =new MyThread(); 
        MyThread t2 =new MyThread(); 
        MyThread t3 =new MyThread(); 
        t1.start();
        t2.start();
        t3.start();
    }
}

