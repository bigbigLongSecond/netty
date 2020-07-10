package datastructure.structure;

import java.util.Arrays;
import java.util.Random;

/**
 * @author dzl
 * 2020/4/4 16:01
 * @Title: ArrayReverce
 * @Description
 */
public class ArrayReverce {

    public void reverce(int[] a , int start , int end){
        System.out.println(Arrays.toString(a));
        for (; start < end ; start++ ,end--){
            int x = a[start];
            a[start] = a[end];
            a[end] = x;
        }
        System.out.println(Arrays.toString(a));
    }
    public void reverseRecursive(int[] a , int start , int end){
        if (start < end){
            int x = a[start];
            a[start] = a[end];
            a[end] = x;
            reverseRecursive(a , ++start , --end);
        }
    }


    public static void main(String[] args) {
        int[] a = new int[9];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(a));
        ArrayReverce arrayReverce = new ArrayReverce();
//        arrayReverce.reverce(a,0,8);
        arrayReverce.reverseRecursive(a,0,8);
        System.out.println(Arrays.toString(a));


    }
}
