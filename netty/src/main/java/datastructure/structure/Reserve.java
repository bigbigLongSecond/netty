package datastructure.structure;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author dzl
 * 2020/4/17 13:43
 * @Description
 */
public class Reserve {

    public static void main(String[] args) {
        Reserve reserve = new Reserve();
        System.out.println( reserve.reserveInt2(1534236469));
    }
    public int reserveInt(int num ){
        if (num<10&&num>-10){
            return num;
        }
        int multiple = 1;
    int res =num;
    while (res /10 != 0){
        res = res/10;
        multiple *= 10;
    }
      int  res1 =num%10 * multiple;
    return res1+reserveInt(num/10);
    }

    public int reserveInt2(int x){
        long a = 0;
        while (x != 0 ){
            a =a*10 + x%10;
            x /= 10;
        }
        if((a>Integer.MAX_VALUE)||(a<Integer.MIN_VALUE)) {
            return 0;
        }
        return (int) a;
    }
}
