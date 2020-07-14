package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static boolean isEmpty(CharSequence cs)
	{
		return (cs == null) || (cs.length() == 0);
	}

	public static boolean isNotEmpty(CharSequence cs)
	{
		return !isEmpty(cs);
	}

	public static boolean isBlank(CharSequence cs)
	{
		int strLen;
		if ((cs == null) || ((strLen = cs.length()) == 0)) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(CharSequence cs)
	{
		return !isBlank(cs);
	}
	/**
	 * 模糊查找匹配的字符串
	 * @param str
	 * @param regs
	 * @return
	 */
	public static  boolean checkStr(String str , String[] regs) {
		if (str == null || str =="" || regs == null || regs.length == 0) return false;
		str = str.toLowerCase();
			for (int i = 0; i < regs.length; i++) {
				if (str.indexOf(regs[i])>-1) {
					str = str.substring(str.indexOf(regs[i]));
				}
				else {
					return false;
				}
			}

			return true;
	}
	/**
	 * 获取字符串数组
	 * @param str
	 * @param regs
	 * @return
	 */
	public static  String[] getStringArray(String text ) {
		if (text != null && text != "") {
			text = text.replace(" ", "").toLowerCase();
			String[] array = text.split("");
			return array;
		}
		return null;
	}
	/**
	 * 判断str是否是数组
	 */
	public static boolean checkIsNum(String str) {
		if(str ==null || str == "") return false;
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
	}


	/**
	 * string 转Double
	 *
	 * @param string
	 * @return
	 */
	public static Double stringToDouble(String string) {
		if (isNotEmpty(string)) {
			try {
				Double d = Double.parseDouble(string);
				return d;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 两字符串比较
	 *
	 * @param string1
	 * @return
	 */
	public static boolean isEqual(String string1 , String string2) {
		if (isEmpty(string1) && isEmpty(string2)) {
			return true;
		}else if (isNotEmpty(string1) && isNotEmpty(string2)){
			return string1.equals(string2);
		}else {
			return false;
		}
	}




	/**
	 * 时间格式化
	 * @param time
	 * @return
	 */
	public static String secondToTime(Double time){
		if (time.isNaN()){
			return "";
		}
		return String.format("%.2f", time);
	}
}
