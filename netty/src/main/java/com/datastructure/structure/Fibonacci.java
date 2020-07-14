package com.datastructure.structure;

/**
 * @author dzl
 * 2020/4/10 9:49
 * @Title: Fibonacci
 * @Description
 */
public class Fibonacci {


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
//        fibonacci.getFibonacci(20);
        long oldTime = System.currentTimeMillis();
//        int count =   fibonacci.getFibonacciA(52);
//        long currentTime = System.currentTimeMillis();
//        System.out.println("值为-->" + count +";耗时为--->" + (currentTime-oldTime)+"ms");
        fibonacci.getFibonacci2(123);
    }

    public int getFibonacci(int first, int second ,int num){
        int num1 = num-1;
        return num>2?(getFibonacci(second-first , first ,num1) + getFibonacci(second , second+first ,num1)):1;
    }

    public int getFibonacciA(int level){
        if (level <1){
            return 0;
        }
        else if(level == 1|| level == 2){
            return 1;
        }
        return getFibonacciA(level-1)+getFibonacciA(level-2);
    }

    public void getFibonacci(int level){
        int a = 1;
        int b = 1;
        int c = 0;
        int count = 0;
        while (level-- >1){
            count = a+b;
            c= a;
            a =count;
            b = c;
            System.out.println("fibonacci--->" + count);
        }

    }
    public long getFibonacci2(int level){
       long f= 0,g=1;
       while (0<level--){
           g = g + f;
           f = g-f;
       }
        System.out.println(g);
       return g;
    }
}
