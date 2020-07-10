package datastructure.structure;

import java.util.Random;

/**
 * @author dzl
 * 2020/4/4 15:26
 * @Title: PopSort
 * @Description 冒泡排序
 */
public class PopSort_1 {
    public static void main(String[] args) {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
            System.out.print(a[i] + "  ");
        }
        System.out.println();
        sortB(a,a.length) ;

    }

    public void sortA(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
            System.out.print(a[i] + "  ");
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int num = 0;
                if (a[i] > a[j]) {
                    num = a[j];
                    a[j] = a[i];
                    a[i] = num;
                }
            }
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }

    public static void sortB(int[] a, int b) {
        for (boolean boo = false; boo = !boo; b--) {
            for (int i = 1; i < b; i++) {
                if (a[i - 1] > a[i]) {
                    int num = 0;
                    num = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = num;
                    boo = false;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
    }


}
