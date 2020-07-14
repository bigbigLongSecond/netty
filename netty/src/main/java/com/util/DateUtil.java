package com.util;

import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 将时间格式化成年月日yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToString(Date date) {
		String dateString = "";
		if (null != date) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dateString = formatter.format(date);
		}
		return dateString;
	}

	public static Date formatStringToDate(String dateString) throws ParseException {
		if (null == dateString || "".equals(dateString)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateString);
		return date;
	}

	/**
	 * 格式化字符串为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date formatStringToComDates(String dateString) throws ParseException {

		if (null == dateString || "".equals(dateString)) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = formatter.parse(dateString);
		return date;
	}

	/**
	 * 格式化日期为yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateToYYYYMMDDString(Date date) {
		String dateString = "";
		if (null != date) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateString = formatter.format(date);
		}
		return dateString;
	}

	public static String formatDateToString(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return formatter.format(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String formatDateToStrings(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("M-dd HH:mm");
			return formatter.format(newDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String strToDateFormat(String date) {
		if (date != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				formatter.setLenient(false);
				Date newDate;
				newDate = formatter.parse(date);
				formatter = new SimpleDateFormat("HH:mm:ss");
				return formatter.format(newDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "";
			}
		} else {
			return "";
		}
	}

	public static Date strToDate(String date) {
		if (date != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				formatter.setLenient(false);
				Date newDate;
				newDate = formatter.parse(date);
				return newDate;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	public static Date strToLong(String date) {
		if (date != null) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				formatter.setLenient(false);
				Date newDate;
				newDate = formatter.parse(date);
				return newDate;
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	public static String strToDateFormats(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			return formatter.format(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static String strToDateFormatsyyyyMMdd(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("yyyyMMdd");
			return formatter.format(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static String strToDateFormatsDD(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("dd");
			return formatter.format(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static String strToDateFormatsyyyyMM(String date) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			formatter.setLenient(false);
			Date newDate;
			newDate = formatter.parse(date);
			formatter = new SimpleDateFormat("yyyyMM");
			return formatter.format(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 格式化日期为yyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateByDefined(Date date, String format) {
		String dateString = "";
		if (null != date) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			dateString = formatter.format(date);
		}
		return dateString;
	}

	// date转毫秒数
	public static Long date2Long(String date) throws Exception {
		if (date == null || date.equals("")) {
			return 0l;
		} else if (date.length() == 10) {
			date += " 00:00:00.000";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date temp = null;
		temp = sdf.parse(date);

		return temp.getTime() / 1000;
	}

	public static String getMaxDate(String date1, String date2) throws Exception {
		if (StringUtils.isEmpty(date1)) {
			return date2;
		}
		if (StringUtils.isEmpty(date2)) {
			return date1;
		}
		return date2Long(date1) > date2Long(date2) ? date1 : date2;
	}

	public static String getMinDate(String date1, String date2) throws Exception {
		if (StringUtils.isEmpty(date1)) {
			return date2;
		}
		if (StringUtils.isEmpty(date2)) {
			return date1;
		}
		return date2Long(date1) > date2Long(date2) ? date2 : date1;
	}

	public static Date getDateByYearMonthDay(Integer year, Integer month, Integer day) {
		if (null == year || year == 0) {
			return null;
		}
		if (null == month || month == 0) {
			return null;
		}
		if (null == day || day == 0) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}

	public static String longToString(long currentTime) {
		String strTime = "";
		if (currentTime != 0) {
			Date date = new Date(currentTime);
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
			strTime = formatter.format(date);
		}
		return strTime;
	}

	public static String getBeforeOrAfterSecTime(String dateStr, double num) throws Exception {
		String result = "";
		if (dateStr != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date = sdf.parse(dateStr);
			long time = date.getTime();
			time = time + (long) (1000 * num);
			Date newDate = new Date(time);

			result = sdf.format(newDate);
		}

		return result;
	}

	public static String getWeekOfDate(Calendar cal) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	public static String getSpendSec(String lastestDateStr, String currentDateStr) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			Date lastestDate = sdf.parse(lastestDateStr);
			long lastestTime = lastestDate.getTime();
			Date currentDate = sdf.parse(currentDateStr);
			long currentTime = currentDate.getTime();

			if (lastestTime > currentTime) {
				return "时间出现问题, 前一次时间大于后一次";
			} else {
				long minu = currentTime - lastestTime;
				float excTime = (float) (minu) / 1000;
				result = String.valueOf(excTime);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String getBcdTime() {
		String time = formatDateByDefined(new Date(), "HH:mm:ss");

		return time;
		// return time.substring(0, 12) + "0" + time.substring(12,
		// time.length());
	}

	/**
	 * @Description: 时间选择器设置范围
	 * @Param: [startPicker, endPicker]
	 * @return: void
	 * @Author: YuDongPing
	 * @Date: 2018/9/19
	 */
	public static void initPicker(DatePicker startPicker, DatePicker endPicker) {
		startPicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(startPicker.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		endPicker.setDayCellFactory(dayCellFactory);
		endPicker.setValue(startPicker.getValue().plusDays(1));
	}

	/**
	 * @description:时间选择器
	 * @param startPicker
	 *            开始时间
	 * @param endPicker
	 *            结束时间
	 * @author ShuJiaFeng
	 * @date 2019/04/24
	 */
	public static void initPickerVersion2(DatePicker startPicker, DatePicker endPicker) {
		startPicker.setValue(LocalDate.now());
		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);
						if (item.isBefore(startPicker.getValue().plusDays(0))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		endPicker.setDayCellFactory(dayCellFactory);
		endPicker.setValue(startPicker.getValue().plusDays(0));
	}

	/**
	 * LocalDate转化为yyyyMMddHHmmssSSS类型的字符串数据
	 * 
	 * @param localDate
	 * @return
	 */
	public static String getStringByLocalDate(LocalDate localDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
		return sdf.format(Date.from(zdt.toInstant()));
	}

	/**
	 * LocalDate转化为yyyyMMddHHmmssSSS类型的字符串数据
	 * 
	 * @param localDate
	 * @return
	 */
	public static String getStringByLocalDateYYYYMMDD(LocalDate localDate) {
		String str = "";
		if (localDate == null)
			return str;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
		return sdf.format(Date.from(zdt.toInstant()));
	}

	/**
	 * 将LocalDate转化为yyyyMMdd235959999类型的字符串数据
	 * 
	 * @param localDate
	 * @return
	 */
	public static String getStringByEndTimeIdentity(LocalDate localDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59.999");
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
		return sdf.format(Date.from(zdt.toInstant()));
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(getBeforeOrAfterSecTime("2017-04-30
		// 23:36:43.000",1));
		// String result = getSpendSec("2017-08-01 10:10:10.200","2017-08-01
		// 10:10:10.900");
//		System.out.println(com.tm.layout.utils.DateUtil.getStringByLocalDate(LocalDate.now().plusDays(-1)));
		System.out.println(longToString_4(1590046855636L ));
	}

	public static String longToString_3(long currentTime) {
		Date date = new Date(currentTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static String longToString_4(long currentTime) {
		Date date = new Date(currentTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(date);
	}

	public static String longToString_2(long currentTime) {
		Date date = new Date(currentTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 
	 * string类型转换为long类型 strTime要转换的String类型的时间 formatType时间格式
	 * strTime的时间格式和formatType的时间格式必须相同
	 * 
	 * @throws ParseException
	 */
	public static long stringToLong(String strTime, String formatType) throws ParseException {
		Date date = stringToDate(strTime, formatType); // String类型转成date类型
		if (date == null) {
			return 0;
		} else {
			long currentTime = date.getTime(); // date类型转成long类型
			return currentTime;
		}
	}

	public static Date stringToDate(String strTime, String formatType) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		Date date = null;
		date = formatter.parse(strTime);
		return date;
	}

	/**
	 * 将LocalDate转化为yyyyMMdd格式的字符串时间
	 * 
	 * @param localDate
	 * @return
	 */
	public static String getStringByLocal(LocalDate localDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
		return sdf.format(Date.from(zdt.toInstant()));
	}

	/**
	 * 将HHmmss转化为HH:mm:ss格式的字符串时间
	 * 
	 * @param timeStr
	 *            HHmmss字符串时间
	 * @return
	 */
	public static String getStringByString(String timeStr) {
		StringBuilder sb = new StringBuilder();
		sb.append(timeStr.substring(0, 2)).append(":").append(timeStr.substring(2, 4)).append(":")
				.append(timeStr.substring(4, 6));
		return sb.toString();
	}
	
	/**
	 * 求出两个时间相差的天数
	 * @param currentTime 当前时间
	 * @param installTime  转辙机安装时间
	 * @return  返回某天,例  "4天",如果installTime为空,返回"--"
	 * @throws ParseException 
	 */
	public static String getDayByStringAndDate(Date currentTime,String installTime){
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int days=0;//返回的天数
		if(installTime!=null&&installTime.length()!=0&&!installTime.equals("0")&&!installTime.equals("")){
			String currentStr=format.format(currentTime);
			Date currentDate=null;
			Date installDate=null;
			try {
				currentDate=format.parse(currentStr);
				installDate=format.parse(installTime);
				days=(int)((currentDate.getTime()-installDate.getTime())/(1000*3600*24));
				if(days>=10000){
					return Double.parseDouble(String.format("%.1f", Double.parseDouble(((double)days/(double)10000)+"")))+"万天";
				}
				return days+"天";
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "--";
		}
		return "--";
	}
	
	/**
	 * 将currentString通过pattern2转化为我们需要的格式
	 * @param currentString
	 * @param pattern2
	 * @return
	 */
	public static String getTimeValueByString(String currentString,String pattern2){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf2=new SimpleDateFormat(pattern2);
		String result="";
		try {
			Date date=sdf.parse(currentString);
			result=sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
