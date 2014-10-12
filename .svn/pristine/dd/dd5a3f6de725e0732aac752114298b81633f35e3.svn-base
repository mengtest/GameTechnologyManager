package com.gametech.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:时间工具类
 * @author pengfei.he
 * @date 2011-6-23
 */
public class DateUtils {
	/**yyyy-MM-dd HH:mm:ss*/
	private static DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static DateFormat logDateFormat = new SimpleDateFormat(
			"yyyyMMddHHmmss");

	private static SimpleDateFormat dayFormater = new SimpleDateFormat(
			"yyyy-MM-dd");

	private static SimpleDateFormat timerOfDayFormater = new SimpleDateFormat(
			"HH:mm:ss");

	private static final DateFormat WINDOWS_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static DateFormat testFormat = new SimpleDateFormat(
			"yyyy-MM-dd_HH-mm-ss");

	private static SimpleDateFormat timerOfDayFormater2 = new SimpleDateFormat(
			"HH:mm");

	private static final DateFormat LINUX_DATE_FORMAT = new SimpleDateFormat(
			"yyyyMMdd HH:mm:ss");
	// 一天的毫秒数
	public static final long ONE_DAY_MS = 24 * 60 * 60 * 1000;

	public static void parserDateFormat() {

	}

	/**
	 * 
	 * <p>
	 * Title: getFormatDate
	 * </p>
	 * <p>
	 * Description: 将毫秒数转为了格式化的日期。
	 * </p>
	 * 
	 * @param ms
	 * @param format
	 * @return
	 * @author guangshuai.wang
	 */
	public static String getFormatDate(long ms) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ms);
		return dateFormat.format(cal.getTime());
	}

	public static String getDefaultFormatByDate(Date date) {
		return dateFormat.format(date);
	}

	public static String getLogFormatByDate(Date date) {
		return logDateFormat.format(date);
	}

	public static DateFormat getLogDateFormat() {
		return logDateFormat;
	}

	public static String getDayFormat(Date date) {
		return dayFormater.format(date);
	}

	public static final Date TIMER_THREE_START_DATE;
	static {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 3);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		TIMER_THREE_START_DATE = calendar.getTime();
	}

	/*** 定时器启动的默认时间 为次日的凌晨 */
	public static final Date TIMER_DEFAULT_START_DATE;

	static {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		TIMER_DEFAULT_START_DATE = calendar.getTime();

	}

	public static final Date TIMER_START_DATE_NOON;

	static {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		TIMER_START_DATE_NOON = calendar.getTime();
	}

	public static Date getTomorrowZeroHour() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_YEAR);

		calendar.set(Calendar.DAY_OF_YEAR, day + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date getNextZeroHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getNoonHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 
	 * @Description 获取时间是一年中的那一天
	 * @author linanjun
	 * @date 2013-9-2 下午04:05:06
	 * @return int
	 */
	public static int currentDayForYear(long selectTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(selectTime);
		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/***
	 * 
	 * @Description 方法说明
	 * @author chen.su
	 * @date 2013-12-22 下午06:01:46
	 * @param day1
	 * @param day2
	 * @return long
	 */
	public static long getDays(long day1, long day2) {

		day1 = day1 / (24 * 60 * 60 * 1000);
		day2 = day2 / (24 * 60 * 60 * 1000);

		return day2 - day1;
	}

	public static String getLoginTime(long nowtime, long lastlogintime) {
		String str = "";
		long xiaoshi = 60 * 60 * 1000;// 一小时
		long yitian = 24 * xiaoshi;// 一天
		long sumtime = nowtime - lastlogintime;
		if (sumtime > 0) {
			if (sumtime < xiaoshi) {
				str = (sumtime / 1000 / 60) + "分钟前";
			} else if (sumtime > xiaoshi && sumtime < yitian) {
				str = (sumtime / xiaoshi) + "小时前";
			} else if (sumtime >= yitian) {
				str = (sumtime / yitian) + "天前";
			}
		}
		return str;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	public static long getDateTime(String date) {

		long day = 0;

		try {
			day = dateFormat.parse(date).getTime();
		} catch (Throwable e) {

		}

		return day;
	}

	public static Date getDefaultDate(String date) throws ParseException {
		return dateFormat.parse(date);
	}

	public static Date getTestDate(String date) throws ParseException {
		return testFormat.parse(date);
	}

	/**
	 * 返回第二天的时间 yyyy-MM-dd 00:00:00
	 * 
	 * @return
	 */
	public static Date getTomorrow() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = c.getTime();
		String t = dayFormater.format(tomorrow);
		try {
			tomorrow = dayFormater.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tomorrow;
	}

	/**
	 * 
	 * @Description 返回第二天早点6点的时间 yyyy-MM-dd 06:00:00
	 * @author linanjun
	 * @date 2012-12-26 下午02:46:53
	 * @return Date
	 */
	public static Date getTomorrowSixHours() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, 1);
		c.add(Calendar.HOUR_OF_DAY, 6);
		Date date = c.getTime();
		String t = dayFormater.format(date);
		try {
			date = dayFormater.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取几天前或者几天后的时间，具体为：YYYY-mm-dd 00:00:00
	 * 
	 * @param days
	 * 
	 * @return
	 */
	public static Calendar getDateTimeByDay(int days) {
		Calendar _date = Calendar.getInstance();
		_date.set(Calendar.AM_PM, Calendar.AM);
		_date.set(Calendar.HOUR, 0);
		_date.set(Calendar.MINUTE, 0);
		_date.set(Calendar.SECOND, 0);
		_date.add(Calendar.DAY_OF_YEAR, days);
		return _date;
	}

	/**
	 * 
	 * @Description 获取N个小时之后的时间
	 * @author linanjun
	 * @date 2013-3-20 下午05:25:20
	 * @param days
	 * @param hour
	 * @return Calendar
	 */
	public static Calendar getDateTimeByNextHour(long days, int hour) {
		Calendar _date = Calendar.getInstance();
		_date.setTimeInMillis(days);
		_date.add(Calendar.HOUR_OF_DAY, hour);
		return _date;
	}

	public static Date getDayOfWeek(Date date, int dayOfWeek) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		//	
		calendar.setTime(date);
		// 设置到本周几
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

		if (calendar.getTime().getTime() >= date.getTime()) {
			// 是之后的直接返回
			return calendar.getTime();
		}

		calendar.add(Calendar.WEEK_OF_MONTH, 1);
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);

		Date nowDate = calendar.getTime();

		return nowDate;
	}

	/**
	 * 
	 * @Description 获取几天前或者几天后的时间，具体为：YYYY-mm-dd 00:00:00
	 * @author linanjun
	 * @date 2012-10-23 下午12:06:10
	 * @param oldTime
	 * @param keepDay
	 * @return String
	 */
	public static String getDateTimeByDay(long oldTime, int keepHour) {
		Calendar _date = Calendar.getInstance();
		_date.setTimeInMillis(oldTime);
		/** 取出旧的时间在当天的哪一小时 */
		int day_hour = _date.get(Calendar.HOUR_OF_DAY);
		/** 计算新的时间 */
		_date.set(Calendar.HOUR_OF_DAY, day_hour + keepHour);
		return getDefaultFormatByDate(_date.getTime());
	}

	/**
	 * @Description 由字符串（指定）格式（yyyy-MM-dd HH:mm:SS）转化成Date
	 * @author linanjun
	 * @date 2012-4-24 下午4:35:36
	 * @param str
	 * @return Date
	 */
	public static Date strChangeToDate(String str) {

		Date date = null;
		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
			date = sd.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 
	 * @Description 将date转换为毫秒
	 * @author linanjun
	 * @date 2013-1-10 下午04:06:44
	 * @param date
	 * @return long
	 */
	public static long dateChangeToLong(Date date) {
		Calendar _date = Calendar.getInstance();
		_date.setTime(date);
		return _date.getTimeInMillis();
	}

	public static Date getTodayLastTime() {
		return null;
	}

	public static boolean isYesterday(long lastRequestRewardTime) {

		if (0 == lastRequestRewardTime) {
			return false;
		}

		Calendar calendar1 = Calendar.getInstance();

		calendar1.setTime(new Date(lastRequestRewardTime));

		Calendar calendar2 = Calendar.getInstance();

		calendar2.setTime(new Date());

		calendar2.add(Calendar.DATE, -1);

		if (calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR)) {
			return false;
		}

		if (calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)) {
			return false;
		}

		if (calendar1.get(Calendar.DAY_OF_MONTH) != calendar2
				.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}

		return true;
	}

	public static boolean isToday(long lastRequestRewardTime) {

		if (0 == lastRequestRewardTime) {
			return false;
		}

		Calendar calendar1 = Calendar.getInstance();

		calendar1.setTime(new Date(lastRequestRewardTime));

		Calendar calendar2 = Calendar.getInstance();

		calendar2.setTime(new Date());

		if (calendar1.get(Calendar.YEAR) != calendar2.get(Calendar.YEAR)) {
			return false;
		}

		if (calendar1.get(Calendar.MONTH) != calendar2.get(Calendar.MONTH)) {
			return false;
		}

		if (calendar1.get(Calendar.DAY_OF_MONTH) != calendar2
				.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	// public static long getLongDate(Date date) {
	// Calendar calendar = Calendar.getInstance();
	//		
	// calendar.setTime(date);
	//		
	// /************************************************************************
	// * + + + + + + + + + *
	// * 0 8 16 24 32 40 48 56 64 *
	// * +-------+-------+-------+-------+-------+-------+-------+-------+ *
	// * + year +month +day +hour +minute +seconds+ + *
	// * +-------+-------+-------+-------+-------+-------+-------+-------+ *
	// ************************************************************************/
	//		
	// // 0xFFFFFFFFFFFFFFFFL
	// // 0x00FFFFFFFFFFFFFFL
	// // 0x0000FFFFFFFFFFFFL
	// // 0x000000FFFFFFFFFFL
	// // 0x00000000FFFFFFFFL
	// // 0x0000000000FFFFFFL
	// // 0x000000000000FFFFL
	// // 0x00000000000000FFL
	//		
	// long year = calendar.get( Calendar.YEAR );
	// long month = calendar.get( Calendar.MONTH );
	// long day = calendar.get( Calendar.DAY_OF_MONTH );
	// long hour = calendar.get( Calendar.HOUR_OF_DAY );
	// long minute = calendar.get( Calendar.MINUTE );
	// long seconds = calendar.get( Calendar.SECOND );
	//		
	// long result = 0;
	//		
	// return result;
	// }

	public static int getWeekDay(int weekday) {

		if (weekday == 1) {
			return Calendar.MONDAY;
		} else if (weekday == 2) {
			return Calendar.TUESDAY;
		} else if (weekday == 3) {
			return Calendar.WEDNESDAY;
		} else if (weekday == 4) {
			return Calendar.THURSDAY;
		} else if (weekday == 5) {
			return Calendar.FRIDAY;
		} else if (weekday == 6) {
			return Calendar.SATURDAY;
		} else if (weekday == 7) {
			return Calendar.SUNDAY;
		}

		return -1;
	}

	public static Date timeOfDayFormater(String str) throws ParseException {
		return timerOfDayFormater.parse(str);
	}

	public static String timeOfDayFormater(Date date) {
		return timerOfDayFormater.format(date);
	}

	public static String timeOfDayFormater2(Date date) {
		return timerOfDayFormater2.format(date);
	}

	public static Date getMonthEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static boolean isMonthEnd() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(new Date(System.currentTimeMillis()));

		return year == calendar.get(Calendar.YEAR)
				&& month == calendar.get(Calendar.MONTH)
				&& day == calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static boolean isMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		calendar.setTime(date);

		return year == calendar.get(Calendar.YEAR)
				&& month == calendar.get(Calendar.MONTH)
				&& day == calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static Date getNextMonthEnd() {
		Calendar calendar = Calendar.getInstance();

		calendar.roll(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);

		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天前的时间（重载）
	 * 
	 * @param d
	 *            字符串类型的时间
	 * @param day
	 * @return String类型的时间
	 */
	public static String getDateBefore(String d, int day) {
		return DateUtils.getDefaultFormatByDate(getDateBefore(
				strChangeToDate(d), day));
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

	/**
	 * 得到几天后的时间（重载）
	 * 
	 * @param d
	 *            字符串类型的时间
	 * @param day
	 * @return String类型的时间
	 */
	public static String getDateAfter(String d, int day) {
		return DateUtils.getDefaultFormatByDate(getDateAfter(
				strChangeToDate(d), day));
	}

	/**
	 * @Description 获取date的零点正
	 * @author pingyang.li
	 * @date 2013-6-7 上午11:49:36
	 * @param date
	 * @return long
	 */
	public static Date getZeroDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取当天时间的最后时间 23:59:59
	 * 
	 * @param d
	 * @return
	 */
	public static Date getLastTimeByDay(Date d) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 59);
		now.set(Calendar.SECOND, 59);

		return now.getTime();
	}

	public static Date getWeekEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	public static Date getNextWeekEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.add(Calendar.WEEK_OF_YEAR, 1);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 00);
		return calendar.getTime();
	}

	public static boolean isWeekDay(Date date, int weekday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) == weekday;
	}

	public static Date getWeekDay(Date date, int weekday) {
		Calendar strDate = Calendar.getInstance();
		strDate.setFirstDayOfWeek(Calendar.MONTH);
		strDate.setTime(date);
		strDate.set(Calendar.DAY_OF_WEEK, weekday);
		return strDate.getTime();
	}

	public static Date getMonthStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getNextMonthStart() {
		Calendar calendar = Calendar.getInstance();

		calendar.roll(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static boolean isOneDay(long time1, long time2) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(time1);

		int year1 = calendar.get(Calendar.YEAR);
		int month1 = calendar.get(Calendar.MONTH);
		int day1 = calendar.get(Calendar.DAY_OF_YEAR);

		calendar.setTimeInMillis(time2);

		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		int day2 = calendar.get(Calendar.DAY_OF_YEAR);

		if (year1 == year2 && month1 == month2 && day1 == day2) {
			return true;
		}

		return false;
	}

	public static Date getTodayHHmmss(String HHmmss) {

		String[] array = HHmmss.split(":");
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(array[0]));
		calendar.set(Calendar.MINUTE, Integer.valueOf(array[1]));
		calendar.set(Calendar.SECOND, Integer.valueOf(array[2]));

		return calendar.getTime();

	}

	public static Date getTodayHHmmss(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String str = "";

		str = str + calendar.get(Calendar.HOUR_OF_DAY) + ":";
		str = str + calendar.get(Calendar.MINUTE) + ":";
		str = str + calendar.get(Calendar.SECOND);

		return getTodayHHmmss(str);

	}

	/**
	 * 返回两个时间之间相差的天数(默认参数1比参数2小)
	 * 
	 * @param atime
	 * @param btime
	 * @return
	 */
	public static int differenceNumberOfDays(long lodTime, long currentTime) {
		long cTime = currentTime - lodTime;
		Long dTime = cTime / ONE_DAY_MS;
		int eTime = dTime.intValue();
		return eTime;
	}

	/**
	 * 
	 * @Description 方法说明
	 * @author chen.su
	 * @date 2013-4-24 下午05:04:18
	 * @param srcDate
	 * @param descDate
	 * @return Date
	 */
	public static Date copyHHmmss(Date srcDate, Date descDate) {

		Calendar calendar = Calendar.getInstance();
		Calendar calendar1 = Calendar.getInstance();

		calendar.setTime(srcDate);
		calendar1.setTime(descDate);

		calendar.set(Calendar.HOUR_OF_DAY, calendar1.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar1.get(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar1.get(Calendar.SECOND));

		return calendar.getTime();
	}

	public static Date deleteMillisecond(Date date) {
		return new Date((date.getTime() / 1000) * 1000);
	}

	public static int getdays1(long time1, long time2) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTimeInMillis(time1);

		int day1 = calendar.get(Calendar.DAY_OF_YEAR);

		calendar.setTimeInMillis(time2);

		int day2 = calendar.get(Calendar.DAY_OF_YEAR);

		return day2 - day1;
	}

	/**
	 * 
	 * @Description 返回两天之间相差的天数, 并假设 time2 >= time1. 如果time2 < time1 则返回-1.
	 * 
	 * @author chen.su
	 * @date 2013-5-23 下午10:16:11
	 * @param time1
	 * @param time2
	 * @return int
	 */
	public static int getdays(long time1, long time2) {
		if (time1 > time2) {
			return -1;
		}

		if (time1 == time2 || isOneDay(time1, time2)) {
			return 0;
		}

		int days = (int) ((time2 - time1) / (long) (24 * 60 * 60 * 1000));

		if ((time2 - time1) % (long) (24 * 60 * 60 * 1000) > 1) {
			days = days + 1;
		}
		return days;
	}

	public static Date getNextMoonDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getMoonDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 11);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 计算两个时间的差值
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long getDateDiff(Date d1, Date d2) {
		long dt1 = d1.getTime();
		long dt2 = d2.getTime();
		return dt1 - dt2;
	}

	public static String getStrDateForLong(long time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return getDefaultFormatByDate(calendar.getTime());
	}

	/**
	 * 
	 * @Description
	 * @author chen.su
	 * @date 2013-8-14 下午12:52:51
	 * @return Date
	 */
	public static final Date getFirstTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 把date 转化为：yyyy-mm-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 * @author guanshuai.wang
	 */
	public static String getDateString(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 
	 * @Description 更新系统时间为输入时间
	 * @author chen.su
	 * @date 2013-9-11 上午09:30:26
	 * @param date
	 * @throws IOException void
	 */
	public static void updateSystemDate(Date date) throws IOException {
		// Operating system name
		String osName = System.getProperty("os.name");
		String cmd = "";
		date = new Date(date.getTime() - 5 * 1000);
		if (osName.matches("^(?i)Windows.*$")) {
			// Window 系统

			// 格式 HH:mm:ss
			String result = WINDOWS_DATE_FORMAT.format(date);
			cmd = "cmd /c time " + result.substring(result.indexOf(" ") + 1);
			Runtime.getRuntime().exec(cmd);
			// 格式：yyyy-MM-dd
			cmd = "cmd /c date " + result.substring(0, result.indexOf(" "));
			Runtime.getRuntime().exec(cmd);
		} else {

			// Linux 系统

			// 我操服务器就是Linux的 你想改服务器的时间 不可能滴!!!!!

			// // 格式：yyyyMMdd
			String result = LINUX_DATE_FORMAT.format(date);
			// 格式 HH:mm:ss
			cmd = "date -s " + result.substring(0, result.indexOf(" "));
			Runtime.getRuntime().exec(cmd);
			System.out.println(cmd);

			cmd = "date -s " + result.substring(result.indexOf(" ") + 1);
			Runtime.getRuntime().exec(cmd);
			System.out.println(cmd);

			//			
		}
	}

	// public static Date getWeekDay( Date startDate, int day ) {
	// return
	// }

	/**
	 * 
	 * @Description 返回下一周的周几,
	 * @author chen.su
	 * @date 2013-12-6 上午05:34:31
	 * @param startDate
	 * @param day
	 *            按英国记录法，比如 1 表示周日 2 表示周一。。。。
	 * @return Date
	 */
	public static Date getNextWeekDay(Date startDate, int day) {

		Calendar strDate = Calendar.getInstance();

		strDate.setFirstDayOfWeek(Calendar.MONDAY);
		strDate.setTime(startDate);
		strDate.add(Calendar.WEEK_OF_YEAR, 1);
		strDate.set(Calendar.DAY_OF_WEEK, day);
		return strDate.getTime();
	}

	/**
	 * 
	 * <p>
	 * Title: isDayOfWeek
	 * </p>
	 * <p>
	 * Description: 判断今天是周几
	 * </p>
	 * 
	 * @param day
	 *            按正常的周几输入，比如周一，就是1
	 * @author guangshuai.wang
	 */
	public static boolean isDayOfWeek(int day) {
		Calendar strDate = Calendar.getInstance();
		if ((strDate.get(Calendar.DAY_OF_WEEK) - 1) == day) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <p>
	 * Title: getEvenNumberHour
	 * </p>
	 * <p>
	 * Description:获取离现在最近的偶数小时毫秒数，比如只获取一天中第0，2，4，6.。。。小时的这毫秒数
	 * </p>
	 * 
	 * @return
	 * @author guangshuai.wang
	 */
	public static long getEvenNumberHour() {
		long result = 0;
		long nowTime = System.currentTimeMillis();
		long zeroTime = DateUtils.getZeroDate(new Date()).getTime();
		long cha = nowTime - zeroTime;
		long hours = cha / (60 * 60 * 1000);
		result = zeroTime;
		if (hours % 2 == 0) {
			result = result + (hours + 2) * 60 * 60 * 1000;
		} else {
			result = result + (hours + 1) * 60 * 60 * 1000;
		}
		return result;
	}

	public static void PrintAllDate(long begin, long end) {
		long oneday = 24 * 60 * 60 * 1000;
		long result = (end - begin) / oneday;
		Date date = new Date();
		for (int i = 0; i < result; i++) {

			date.setTime(begin);
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(formater.format(date));
			begin = begin + oneday;
		}

	}

	public static void main(String[] args) {

		System.out.println(DateUtils.getFormatDate(1397012474938L));
	}

}
