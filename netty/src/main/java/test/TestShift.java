package test;

import util.ByteUtil;

import java.util.Arrays;

/**
 * @author dzl
 * 2020/6/28 15:39
 * @Description
 */
public class TestShift {
    public static void main(String[] args) {
        short  a = 100;
        byte[] bytes = ByteUtil.shortToByte16(a);
        System.out.println(Arrays.toString(bytes));

    }
}
