package com.looveh.blog_web.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类
 * 
 * @author liqun.wang 2015-5-28 下午04:43:04
 */
public class DateUtil {

	public final static String STYLE_1 = "yyyy-MM-dd HH:mm:ss";

	public final static String STYLE_2 = "yyyy-MM-dd";

	public final static String STYLE_3 = "yyyyMMdd";

	public final static String STYLE_4 = "yyyyMMddhh";

	public final static String STYLE_5 = "yyyyMMddhhmm";

	public final static String STYLE_6 = "yyyy年MM月dd日HH时mm分ss秒";

	public final static String STYLE_7 = "yyyy年MM月dd日HH时mm分";

	public final static String STYLE_8 = "yyyy年MM月dd日";

	public final static String STYLE_9 = "hhmmss";

	public final static String STYLE_10 = "yyyy-MM";   //格式化时间为月份

	public final static String STYLE_11 = "dd";

	public final static String STYLE_13 = "MM-dd";

	public final static String STYLE_12 = "MM";

	public final static String STYLE_14 = "yyyy";

	public final static String STYLE_15 = "yyyy-MM-dd HH:mm";

	public final static String STYLE_16 = "HH:mm";

	public final static String STYLE_17 = "HH:mm:ss";

	public final static String STYLE_18 = "yyyy年MM月dd日";

	public final static String STYLE_19 = "yyyyMM";

	public final static String STYLE_20 = "MM-dd HH:mm";

	public final static String STYLE_21 = "MM月dd日";






	public static DateFormat yyyyMM() {
		return new SimpleDateFormat("yyyyMM");
	}

	public static DateFormat yyyyMMdd() {
		return new SimpleDateFormat("yyyyMMdd");
	}

	/**
	 * 比较两个日期相差的天数
	 */
	public static int getMargin(String date1, String date2) {
		int margin;
		try {
			ParsePosition pos = new ParsePosition(0);
			ParsePosition pos1 = new ParsePosition(0);
			Date dt1 = new SimpleDateFormat("yyyyMMdd").parse(date1, pos);
			Date dt2 = new SimpleDateFormat("yyyyMMdd").parse(date2, pos1);
			long l = dt1.getTime() - dt2.getTime();
			margin = (int) (l / (24 * 60 * 60 * 1000));
			return margin;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 比较两个日期相差的天数
	 */
	public static int getMargin(Date date1, Date date2) {
		int margin;
		try {
			long l = date1.getTime() - date2.getTime();
			margin = (int) (l / (24 * 60 * 60 * 1000));
			return margin;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 获取下一个月
	 */
	public static String nextMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		return new SimpleDateFormat("yyyyMM").format(calendar.getTime());
	}

	/**
	 * （A年-B年）* 12 - B月+A月
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonths(Date date1, Date date2) {
		Calendar calendarBirth = Calendar.getInstance();
		calendarBirth.setTime(date1);
		Calendar calendarNow = Calendar.getInstance();
		calendarNow.setTime(date2);
		return (calendarNow.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR)) * 12
				+ calendarNow.get(Calendar.MONTH) - calendarBirth.get(Calendar.MONTH);
	}

	public static String getNowDateFormat(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

    public static String getDateYearsAgo(int years)
    {
        Calendar now = Calendar.getInstance();
        //获取年份
        Integer beforeYear=now.get(Calendar.YEAR) -years;
        //获取月份
        Integer month=now.get(Calendar.MONTH) + 1;
        //获取日期
        Integer day=now.get(Calendar.DATE);

        return  beforeYear+"-"+String.format("%02d", month)+"-"+String.format("%02d", day);
    }

	public static String dayOfWeek(String date)
	{
		try
		{
			Date _date = formatDate(date, null);

			SimpleDateFormat dateFm = new SimpleDateFormat("EEEE"); // 星期几

			String day_of_week = dateFm.format(date);

			return day_of_week;
		}
		catch (Exception e)
		{
			return "";
		}

	}




	/**
	 *
	 * 功能说明：获得当前时间
	 * chuanqi  2014-11-29
	 * @param style 时间类型		如果style 则默认返回yyyy-MM-dd HH:mm:ss
	 * @return String 时间字符串   
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getCurrentTime(String style) {
		if(style==null || style.equals("")){
			style = STYLE_1;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String str = sdf.format(new Date());
		return str;
	}

	/**
	 *
	 * 功能说明：获得当前时间
	 * chuanqi  2014-11-29
	 * @param style 时间类型		如果style 则默认返回yyyy-MM-dd HH:mm:ss
	 * @return String 时间字符串   
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(STYLE_1);
		String str = sdf.format(new Date());
		return str;
	}


	/**
	 *
	 * 功能说明：获得指定时间的样式
	 * chuanqi  2014-11-29
	 * @param times 		指定时间
	 * @return String 时间样式
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getDateStyle(String times) {

		try {
			formatDate(times,STYLE_1);
			return STYLE_1;
		} catch (Exception e) {
//			e.printStackTrace();
		}

		try {
			formatDate(times,STYLE_2);
			return STYLE_2;

		} catch (Exception e) {
//			e.printStackTrace();
		}
		try {
			formatDate(times,STYLE_3);
			return STYLE_3;

		} catch (Exception e) {
//			e.printStackTrace();
		}

		try {
			formatDate(times,STYLE_4);
			return STYLE_4;

		} catch (Exception e) {
//			e.printStackTrace();
		}

		return null;
	}



	/**
	 *
	 * 功能说明：格式化日期
	 * chuanqi  2014-11-29
	 * @param time 被格式化的日期   fmtStyle  格式化前的样式  wantStyle 格式化后的样式
	 * @return String 格式化后的日期
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String formatDate(String time,String fmtStyle,String wantStyle){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmtStyle);
			Date date = sdf.parse(time);
			sdf = new SimpleDateFormat(wantStyle);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}

	}

	public static String formatDate(Date date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(STYLE_1);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public static String formatDate(Date date, String fmtStyle){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmtStyle);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 *
	 * 功能说明：格式化日期
	 * chuanqi  2014-11-29
	 * @param  times 预格式化的日期字符串   style 格式化后的样式  默认是 yyyy-MM-dd HH:mm:ss
	 * @return Date   
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static Date formatDate(String times, String style) throws ParseException {
		if (style == null || "".equals(style)) {
			style = STYLE_1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		return sdf.parse(times);
	}

	/**
	 *
	 * 功能说明：根据生日求年龄 周岁
	 * chuanqi  2014-11-29
	 * @param birthDay  生日
	 * @return int 周岁  
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int getAgeByBirthDay(String birthDay) {
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(STYLE_2);
			Date date = sdf.parse(birthDay);
			if (cal.before(date)) {
				return 0;
			}
			int yearNow = cal.get(Calendar.YEAR);
			cal.setTime(date);
			int yearBirth = cal.get(Calendar.YEAR);

			int age = yearNow - yearBirth;


			return age;
		}catch (Exception e){
			return 0;

		}
	}


	/**
	 *
	 * 功能说明：比较两个日期 大小
	 * chuanqi  2014-11-29
	 * @param DATE1 日期1  DATE2 日期2
	 * @return   返回 int (-1 ：日期1 大于 日期2,0 ：日期1 小于日期2, 1： 日期1 等于日期2)
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int compareDate(String DATE1, String DATE2,String style) {
		int i = 0;
		if(style == null)
			style = STYLE_1;

		SimpleDateFormat df = new SimpleDateFormat(style);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				i = -1;
			} else if (dt1.getTime() < dt2.getTime()) {
				i = 0;
			} else if (dt1.getTime() == dt2.getTime()) {
				i = 1;
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return i;
	}


	/**
	 *
	 * 功能说明：获得指定日期的最后一天
	 * chuanqi  2014-11-29
	 * @param  date 指定日期
	 * @return   
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static Date lastDayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 *
	 * 功能说明：获得本月第一天日期
	 * chuanqi  2014-11-29
	 * @param 
	 * @return   String 2015-05-01
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getMonthBegin() {
		Calendar localTime = Calendar.getInstance();
		String strY = null;
		int x = localTime.get(Calendar.YEAR);
		int y = localTime.get(Calendar.MONTH) + 1;
		strY = y >= 10 ? String.valueOf(y) : ("0" + y);
		return x + "-" + strY + "-01";
	}


	/**
	 *
	 * 功能说明：获得本月最后一天日期
	 * chuanqi  2014-11-29
	 * @param 
	 * @return   String 2015-05-01
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getMonthEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		int endday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return calendar.get(Calendar.YEAR) + "-"+ (calendar.get(Calendar.MONTH) + 1) + "-" + endday;
	}

	/**
	 *
	 * 功能说明：判断指定日期是否为周六
	 * chuanqi  2014-11-29
	 * @param  date  日期字符串
	 * @return   
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static boolean isWeekOfSaturday(String date) throws ParseException {

		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date bdate = format1.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(bdate);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
			return true;
		return false;
	}

	/**
	 *
	 * 功能说明：判断指定日期是否为周日
	 * chuanqi  2014-11-29
	 * @param  date  日期字符串
	 * @return   
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static boolean isWeekOfSunday(String bDate) throws ParseException {

		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date bdate = format1.parse(bDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(bdate);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			return true;
		return false;
	}


	/**
	 *
	 * 功能说明：求得指定日期的前N天日期
	 * chuanqi  2014-11-29
	 * @param  date 日期 ，day 天数 ，style 预转换的日期格式 （默认为 yyyy-MM-dd HH:mm:ss）
	 * @return  String  
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getBefore(Date date, int day,String style) {
		if(StringUtils.isEmpty(style)){
			style = STYLE_1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		sdf.format(date);
		return  sdf.format(now.getTime());
	}


	/**
	 *
	 * 功能说明：求得指定日期的后N天日期
	 * chuanqi  2014-11-29
	 * @param  date 日期 ，day 天数 ，style 预转换的日期格式 （默认为 yyyy-MM-dd HH:mm:ss）
	 * @return  String  
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getAfter(String sdate, int day,String style) {
		if(StringUtils.isEmpty(style)){
			style = STYLE_1;
		}
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try{
			date = d.parse(sdate);//初始日期
		}catch(Exception e){

		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		sdf.format(date);
		return  sdf.format(now.getTime());
	}





	/**
	 *
	 * 功能说明：根据年龄 求N年前的日期
	 * chuanqi  2014-11-29
	 * @param  age 年龄
	 * @return  String  
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getBeforeDay( int age) {

		Calendar now = Calendar.getInstance();
		//获取年份
		Integer beforeYear=now.get(Calendar.YEAR) -age;
		//获取月份
		Integer month=now.get(Calendar.MONTH) + 1;
		//获取日期
		Integer day=now.get(Calendar.DATE);

		return  beforeYear+"-"+String.format("%02d", month)+"-"+String.format("%02d", day);
	}

	/**
	 *
	 * 功能说明：求得指定日期的前N月日期
	 * chuanqi  2014-11-29
	 * @param  date 日期 ，month 月数 ，style 预转换的日期格式 （默认为 yyyy-MM-dd HH:mm:ss）
	 * @return  String  
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getBeforeMonth(String beforeDate, int month,String style) {
		if(StringUtils.isEmpty(style)){
			style = STYLE_1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		Date date = null;
		try{
			date = sdf.parse(beforeDate);//初始日期
		}catch(Exception e){

		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH,-month);//在日历的月份上减少n个月
		return  sdf.format(now.getTime());
	}


	/**
	 *
	 * 功能说明：是否为闰年
	 * chuanqi  2015-5-13
	 * @param year 年份
	 * @return   boolean
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static boolean leapYear(int year) {
		boolean leap;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		return leap;
	}



	/**
	 *
	 * 功能说明：根据当前日期计算出后面几个月后的日期或者 几天后的日期
	 * chuanqi  2015-5-13
	 * @param nowTime 当时日期     type{2 代表月 其它代表 日}   style 指定格式化日期样式 默认 yyyy-MM-dd HH:mm:ss
	 * @return   
	 * @throws	 ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getLastTime(String nowTime, int type, int increment,String style) throws ParseException {
		if (style == null || "".equals(style)) {
			style = STYLE_1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(nowTime));
		if (type == 2)
			calendar.add(Calendar.MONTH, increment);
		else
			calendar.add(Calendar.DAY_OF_MONTH, increment);

		String sdate = sdf.format(calendar.getTime());
		calendar.setTime(sdf.parse(sdate));
		return sdate;
	}


	/**
	 *
	 * 功能说明：求两个日期之间相隔天数
	 * chuanqi  2015-5-13
	 * @param  time1 日期1   time2 日期2
	 * @return long   相差天数
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static long getBetweenDays(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(STYLE_2);
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.abs(quot);
	}


	/**
	 *
	 * 功能说明：求两个日期相差的天数
	 * chuanqi  2015-5-13
	 * @param 
	 * @return   天数（int）
	 * @throws  ParseException
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int diffDays(String startDate, String endDate)throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(startDate));
		long startTime = cal.getTimeInMillis();
		cal.setTime(sdf.parse(endDate));
		long endTime = cal.getTimeInMillis();
		long between_days = (endTime - startTime) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}





	public static int getYear(String date){

		if(StringUtils.isEmpty(date))
		{
			return 0;
		}

		String[] arr = date.split("-");

		if(arr==null || arr.length==0)
		{
			return 0;
		}

		int ret = 0;

		try
		{
			ret = Integer.valueOf(arr[0]);

			return ret;
		}
		catch (Exception e)
		{
			return 0;
		}
	}


	/**
	 *
	 * 功能说明：得到当前时间所处的时间段
	 * chuanqi  2015-5-13
	 * @param 
	 * @return   1  凌晨 2 早上 3中午 4下午 5 晚上
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int PeriodOfTime(){
		Calendar calendar =  Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int result = 0;
		//早上
		if(hours >=0 && hours <= 5){
			//凌晨
			result = 1;
		}else if(hours >=6 && hours <= 10){
			//早上
			result = 2;
		}else if(hours >=11 && hours <= 13){
			//中午
			result = 3;
		}else if(hours >=14 && hours <= 18){
			//下午
			result = 4;
		}else if(hours >=19 && hours <= 24){
			//晚上
			result = 5;
		}
		return result;
	}

	/**
	 *
	 * 功能说明：获得当前年份
	 * chuanqi  2015-5-13
	 * @param 
	 * @return   年份
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int getCurrentYear(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 *
	 * 功能说明：获得当前月份
	 * chuanqi  2015-5-13
	 * @param 
	 * @return  月份
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int getCurrentMonth(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}







	/**
	 *
	 * 功能说明：获得当前日份
	 * chuanqi  2015-5-13
	 * @param 
	 * @return  日
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int getCurrentDay(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DATE);
	}


	/**
	 *
	 * 功能说明：该方法实现的功能
	 * chuanqi  2015-5-13
	 * @param 
	 * @return  日
	 * @throws 
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static int getCurrentHour(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.HOUR_OF_DAY);
	}











	/**
	 *
	 * 功能说明：获得 当前时间的前几分钟时间
	 * chuanqi  2015-6-1
	 * @param 
	 * @return   
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getBeforeSeconds(int second,String style){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.SECOND, now.get(Calendar.SECOND) - second);
		sdf.format(date);
		return sdf.format(now.getTime());
	}



	/**
	 *
	 * 功能说明：获得某个日期N个月份之前的的月份
	 * chuanqi  2015-11-19 15:19:09
	 * @param 
	 * @return   
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String  getMonthBefore(String dateStr, int n) throws ParseException {
		Calendar datebefore = Calendar.getInstance();//获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date date = null;
		try{
			date = sdf.parse(dateStr);//初始日期
		}catch(Exception e){

		}
		datebefore.setTime(date);//设置日历时间
		datebefore.add(Calendar.MONTH, -n);//在日历的月份上减少呢n个月
		String result = sdf.format(datebefore.getTime());
		return result;
	}

	/**
	 *
	 * 功能说明：获得某个日期N个月份之后的月份（包含该日期所在的月份，不能超过当前月份）
	 * chuanqi  2015-11-19 15:19:09
	 * @param 
	 * @return   
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：chuanqi
	 * 修改内容：
	 * 修改注意点：
	 */
	public static String getMonthAfter(String dateStr, int n) throws ParseException {
		Calendar datebefore = Calendar.getInstance();//获得一个日历的实例

		Calendar datacurrent = Calendar.getInstance();//用于获取当前时间

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date date = null;
		try{
			date = sdf.parse(dateStr);//初始日期
		}catch(Exception e){

		}
		datebefore.setTime(date);//设置日历时间
		datebefore.add(Calendar.MONTH, n);//在日历的月份上增加n个月

		datacurrent.setTime(new Date());

		String result = null;

		if(datebefore.getTime().before(datacurrent.getTime())){
			result = sdf.format(datebefore.getTime());
		}else{
			result = sdf.format(datacurrent.getTime());
		}

		return result;
	}




	/**
	 * @Tiele：minConvertHourMin
	 * @Describe：根据分钟计算天，时，分
	 * @param
	 * @return
	 */
	public static String minConvertHourMin(int min){
		String resultTime = "";

		if(min != 0){
			String format;
			Object[] array;
			Integer days = min/(60*24);
			Integer hours = (min/60)-days*24;
			Integer minutes = min-hours*60-days*24*60;

			if(days > 0){

				if(hours > 0 && minutes <= 0){
					format = "%1$,d天%2$,d小时";

				}else if(hours == 0 && minutes == 0) {

					format = "%1$,d天";
				}else{
					format = "%1$,d天%2$,d小时%3$,d分";
				}

				array = new Object[]{days,hours,minutes};
			}else if(hours>0){
				if(minutes <= 0){
					format = "%1$,d小时";
				}else{
					format = "%1$,d小时%2$,d分";
				}

				array = new Object[]{hours,minutes};
			}else{
				format = "%1$,d分";
				array = new Object[]{minutes};
			}
			resultTime = String.format(format, array);
		}
		return resultTime;
	}

	public static String RemoveDecimalOfDateTime(String datetime)
	{
		if(StringUtils.isEmpty(datetime))
		{
			return datetime;
		}

		String[] ar=datetime.split("\\.");

		if(ar.length>0)
		{
			datetime=ar[0];
		}

		return datetime;
	}



	/**
	 *
	 * 功能说明：获得两个日期之间的所有月份或年份
	 * chuanqi  2015-11-19 15:19:09
	 * @param 
	 * @return   
	 * @throws  该方法可能抛出的异常，异常的类型、含义。
	 * 最后修改时间：
	 * 修改人：关福旺
	 * 修改内容：
	 * 修改注意点：
	 */
	public static List<String> getDateBetween(String minDate, String maxDate, String style) {
		try{

			ArrayList<String> result = new ArrayList<String>();
			SimpleDateFormat sdf = new SimpleDateFormat(style);//格式化为年月

			Calendar min = Calendar.getInstance();
			Calendar max = Calendar.getInstance();

			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

			Calendar curr = min;
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				if(DateUtil.STYLE_12.equals(style)){
					curr.add(Calendar.YEAR, 1);
				}
				if(DateUtil.STYLE_13.equals(style)){
					curr.add(Calendar.MONTH, 1);
				}
			}
			return result;
		}catch(Exception e){
			return null;

		}

	}



	//根据日期取得星期几
	public static String getWeek(String strDate){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			Date date=sdf.parse(strDate);
			String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
			if (w < 0)
				w = 0;
			return weekDays[w];
		}catch(Exception e){
			return null;

		}
	}

	//判断两个日期之间是否相差一小时
	public static boolean caculateDateOneHour(Date beginDate,Date endDate){
		BigDecimal beginTimes = new BigDecimal(beginDate.getTime());
		BigDecimal endTimes = new BigDecimal(endDate.getTime());
		return endTimes.subtract(beginTimes).subtract(new BigDecimal(3600000)).compareTo(BigDecimal.ZERO)>=0;
	}

	public static String getCurChinaDate() {
		return new SimpleDateFormat(STYLE_8).format(new Date());
	}

	public static Date addMonth(Date now, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}
	/**
	 * 获取一个月之前的日期
	 * @return
	 */
	public static String getOneBeforeMonthDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.MONTH, -1);
		Date m = c.getTime();
		String mon = format.format(m);
		return mon;


	}
	/**
	 * 获取一年之前的日期
	 * @return
	 */
	public static String getOneBeforeYearDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -1);
		Date y = c.getTime();
		String year = format.format(y);
		return year;


	}
}
