package com.datastructure.structure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dzl
 * 2020/4/14 15:41
 * @Description
 */
public class PatternTest {
    public static void main(String[] args) {
        String regex = "";
        String text = "HERE IS A SIMPLE EXAMPLE";
//        example();
        if (stringMatch(text , regex)){
            System.out.println("pattern ok");
        }
    }

    public static void example() {
        String regex = "SAP";
        String text = "HERE IS A SIMPLE EXAMPLE";
        Pattern pattern = Pattern.compile(text, Pattern.LITERAL);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.find()) {
            System.out.println("hell");
        }
    }

    public static void find() {
        String a = "sd3";
        a = a.replace("", "*");
        String b = "asfdd3r2";
        if (Pattern.matches(a, b)) {
            System.out.println("hellp");
        }
        System.out.println(a);
    }


    private static boolean stringMatch(String string, String target) {
        System.out.println("string-->" + string + "  target--->" + target);
        if (target.length() == 1) {
            return string.indexOf(target) > -1;
        } else {
            String a = target.toUpperCase().substring(0, 1);
            int index = string.toUpperCase().indexOf(a);
            return index > -1 ? stringMatch(string.substring(index), target.substring(1)) : false;
        }
    }
}
