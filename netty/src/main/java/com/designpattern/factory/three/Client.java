package com.designpattern.factory.three;

import com.designpattern.factory.one.Fruit;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author dzl
 * 2020/10/20 15:19
 * @Description 抽象工厂模式
 */
public class Client {
    public static void main(String[] args) {
//        IFactory appleFactory = new AppleFactory();
//        Fruit fruit = appleFactory.create();
//        fruit.eat();
//        System.out.println(System.nanoTime());
//        System.out.println(System.currentTimeMillis());
//        try {
//            Thread.sleep(10000);
//            new Random();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.nanoTime());
        Client client = new Client();
        int[] array = {3, 2, 1, 4, 2, 4, 5, 6, 3};
        client.fastSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }


    public void insert(int[] array) {
        int j, temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && array[j] < temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public void fastSort(int[] array, int lo, int hi) {
        if (lo > hi){
            return;
        }
        int i, j, temp;
        i = lo;
        j = hi;
        temp = array[lo];
        while (i != j) {
            while (array[j] >= temp && j > i) {
                j--;
            }
            while (array[i] <= temp && j > i) {
                i++;
            }
            if (j > i) {
                swap(array, i, j);
            }
        }
        swap(array, lo, i);
        fastSort(array, lo, i - 1);
        fastSort(array, i + 1, hi);
    }

    private void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }
}
