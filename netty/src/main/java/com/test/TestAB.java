package com.test;

public class TestAB {
     public static void main(String[] args) {
		String a = "0";
		System.out.println(isNumeric(a));
	}
     
  // 方法五：用ascii码
 	public static boolean isNumeric(String str) {
 		for (int i = str.length(); --i >= 0;) {
 			int chr = str.charAt(i);
 			if (chr > 47 && chr < 58)
 				return true;
 		}
 		return false;
 	}
}
