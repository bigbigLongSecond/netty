package com.datastructure.structure;

/**
 * @author dzl
 * 2020/4/24 12:26
 * @Description
 */
public class FindMax {

    public static void main(String[] args) {
        FindMax findMax = new FindMax();
        int[] a = {12,43,45,35,3,53,53,53,53,5,352235,4,65,45,5745,6467,768,56,845,85,75,86,7,7665,545};
        findMax.findMax(a);
    }

    public void findMax(int[] a){
        int max = 0;
        int min = 0;
        int alength = a.length;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                alength = max;
                max = a[i];
                min = alength;
            }else if (a[i] >min && a[i]<max){
                min = a[i];
            }
        }
        System.out.println("min  :" +min +", max  :" +max);
    }
}
