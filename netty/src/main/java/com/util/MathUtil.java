package com.util;

import java.math.BigDecimal;
import java.util.List;

/**
 * 大数据精度计算处理工具类
 *
 * @author zhang_fei
 * @date 2018年4月24日
 */
public class MathUtil {

    private MathUtil() {
    }

    /**
     * 数据相加
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal add(Object param1, Object param2) {
        return add(toNumber(param1), toNumber(param2));
    }

    /**
     * 字符串数据相加
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal add(String param1, String param2) {
        return add(toNumber(param1), toNumber(param2));
    }

    /**
     * 字符串数据相加
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal add(BigDecimal param1, BigDecimal param2) {
        return param1.add(param2);
    }

    /**
     * param1除以param2，保留round位小数
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @param round  保留小数点的位数
     */
    public static BigDecimal divide(BigDecimal param1, BigDecimal param2, int round) {
        return param1.divide(param2, round, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * param1除以param2
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal divide(String param1, String param2) {
        return divide(param1, param2, 0);
    }

    /**
     * param1除以param2，保留round位小数
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @param round  保留小数点的位数
     */
    public static BigDecimal divide(String param1, String param2, int round) {
        return divide(toNumber(param1), toNumber(param2), round);
    }

    /**
     * param1除以param2
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal divide(Object param1, Object param2) {
        return divide(String.valueOf(param1), String.valueOf(param2));
    }

    /**
     * param1除以param2，保留round位小数
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     * @param round  保留小数点的位数
     */
    public static BigDecimal divide(Object param1, Object param2, int round) {
        return divide(String.valueOf(param1), String.valueOf(param2), round);
    }

    /**
     * param1减去param2
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal subtract(BigDecimal param1, BigDecimal param2) {
        return param1.subtract(param2);
    }

    /**
     * param1减去param2
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal subtract(String param1, String param2) {
        return subtract(toNumber(param1), toNumber(param2));
    }

    /**
     * param1减去param2
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static BigDecimal subtract(Object param1, Object param2) {
        return subtract(String.valueOf(param1), String.valueOf(param2));
    }

    /**
     * > 返回1, = 返回0, < 返回-1
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static int compareTo(BigDecimal param1, BigDecimal param2) {
        return param1.compareTo(param2);
    }

    /**
     * > 返回1, = 返回0, < 返回-1
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static int compareTo(String param1, String param2) {
        return compareTo(toNumber(param1), toNumber(param2));
    }

    /**
     * > 返回1, = 返回0, < 返回-1
     *
     * @param param1 第一个参数
     * @param param2 第二个参数
     */
    public static int compareTo(Object param1, Object param2) {
        return compareTo(String.valueOf(param1), String.valueOf(param2));
    }

    /**
     * 计算数组平均值，保留round位小数
     *
     * @param arr   需要计算的数组
     * @param round 保留小数点的位数
     */
    public static BigDecimal avg(String[] arr, int round) {
        BigDecimal sum = toNumber("0");
        for (String str : arr) {
            sum = add(sum, toNumber(str));
        }
        return divide(sum, toNumber(arr.length), round);
    }

    /**
     * 计算数组平均值，保留round位小数
     *
     * @param arr   需要计算的数组
     * @param round 保留小数点的位数
     */
    public static BigDecimal avg(List<String> arr, int round) {
        return avg(arr.toArray(new String[0]), round);
    }

    /**
     * 保留小数位
     *
     * @param param 源数值
     * @param round 保留小数点的位数
     */
    public static BigDecimal setScale(BigDecimal param, int round) {
        return param.setScale(round, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 保留小数位
     *
     * @param param 源数值
     * @param round 保留小数点的位数
     */
    public static BigDecimal setScale(String param, int round) {
        return setScale(toNumber(param), round);
    }

    /**
     * 保留小数位
     *
     * @param param 源数值
     * @param round 保留小数点的位数
     */
    public static BigDecimal setScale(Object param, int round) {
        return setScale(String.valueOf(param), round);
    }

    /**
     * 判断是否不是一个数字
     * <p>is not a number</p>
     *
     * @param param 源数值
     */
    public static boolean isNaN(String param) {
        try {
            Double.parseDouble(param);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    /**
     * 转换为数字
     *
     * @param value 值
     * @return 数字
     */
    public static BigDecimal toNumber(String value) {
        return new BigDecimal(value);
    }

    /**
     * 转换为数字
     *
     * @param value 值
     * @return 数字
     */
    public static BigDecimal toNumber(Object value) {
        return toNumber(String.valueOf(value));
    }

    /**
     * 返回绝对值
     *
     * @param value 值
     * @return 绝对值
     */
    public static BigDecimal abs(String value) {
        return toNumber(value).abs();
    }

    /**
     * 返回绝对值
     *
     * @param value 值
     * @return 绝对值
     */
    public static BigDecimal abs(Object value) {
        return abs(String.valueOf(value));
    }

    public static void main(String[] args) {
        System.out.println(divide(100.00, 21.0, 2));
        System.out.println(setScale("3.3555651", 2));
        System.out.println(getStringByInt(1985));
    }
    
    /**
     * 将字符串值转化为保留两位小数的double值
     * @param deviceScore  "90.342432"类型的字符串double数值
     * @return  返回double值,如果deviceScore为空,则返回0
     */
    public static double getDoubleByString(String deviceScore){
    	if(deviceScore!=null&&deviceScore.length()!=0){
    		return Double.parseDouble(String.format("%.2f", Double.parseDouble(deviceScore)));
    	}
    	return 0;
    }


    /**
     * 将操岔次数转化为 (一千以内的直接显示值,一千以上的显示4.33千,4.33万类型的)
     * @param currentTurnoutNum  操岔次数
     * @return
     */
    public static String getStringByInt(int currentTurnoutNum){
    	if(currentTurnoutNum<10000){
    		return currentTurnoutNum+"";
    	}else if(currentTurnoutNum>=10000){
    		double currentDouble=Double.parseDouble(currentTurnoutNum+"")/10000;
    		return Double.parseDouble(String.format("%.2f", currentDouble))+"万";
    	}
    	return "0";
    }
}
