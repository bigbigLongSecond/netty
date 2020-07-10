package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dzl
 * 2020/3/31 9:10
 * @Title: Test
 * @Description
 */
public class Test {
    public  static long[] b = new long[100000];
    static {
        for (long i = 0; i <b.length ; i++) {
            b[(int) i] = i;

        }
    }

    public static void main(String[] args) {
//        Map<Integer, String> hashMap = new HashMap();
//       hashMap.put(213,"hello");
//        Map<Integer, String> hashMap1 = new HashMap();
//       hashMap1.put(213,"hello");


        long oldtime = System.currentTimeMillis();

        getSum(b ,b.length);
        long current = System.currentTimeMillis();
        System.out.println(current -oldtime);

        oldtime = System.currentTimeMillis();
        System.out.println("总和为"+ getTot(b ,b.length-1));
        current = System.currentTimeMillis();
        System.out.println(current -oldtime);
    }

    public static  void  getSum( long[]  a , int n){
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += a[i];
        }
        System.out.println("总和为："  + count);
    }


    public static long getTot(long[] a , int c){
        return c>0?(a[c] + getTot(a , c-1)):0;
    }
}
