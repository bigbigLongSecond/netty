package datastructure.structure;

import java.util.Vector;

/**
 * @author dzl
 * 2020/4/24 13:13
 * @Description  寻找两个字符串的最长子序列
 */
public class SubSequence {

    public String Lcs(String a , String b){
        if (a.length() == 0 || b.length() == 0){
            return "";
        }
        String x = a.substring(a.length()-1);
        String y = b.substring(b.length()-1);
        return x.equals(y)?Lcs(a.substring(0,a.length()-1),b.substring(0,b.length()-1))+x:Lcs(a.substring(0,a.length()-1),b.substring(0,b.length()-1));


    }

    public static void main(String[] args) {
        String a = "asdsfsa";
        String x = "asasdw";
        SubSequence subSequence = new SubSequence();
        System.out.println(subSequence.Lcs(a, x));
    }
}
