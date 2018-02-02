package com.loveboy.commons.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyyMMddHHmmssSSS", "yyyyMMdd"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getYestoDay() {
        Date d = new Date();
        d = DateUtils.addDate(d, "3", -1);
        return formatDate(d, "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式（"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss" ）
     */
    public static Date parseDate(String str) {
        try {
            return parseDate(str, parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前月的yyyyMM
     * @return
     */
    public static String getyyyyMM() {
        return formatDate(new Date(), "yyyyMM");
    }

    /**
     * 获取上个月yyyyMM
     * @return
     */
    public static String getUpyyyMM() {
        Calendar cal_1 = Calendar.getInstance();//获取当前日期
        cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cal_1.getTime());
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        return formatDate(calendar.getTime(), "yyyyMM");
    }

    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    //返回两个日期相差的秒数
    public static long getTimeOut(String date1, String date2) throws Exception {
        return (SimpleDateFormat.getDateTimeInstance().parse(date2).getTime() - SimpleDateFormat.getDateTimeInstance().parse(date1).getTime()) / 1000;
    }

    /**
     * 返回两个日期相差天数
     * @return
     * @throws Exception
     */
    public static long getDifDay(Date firstDate, Date secondDate) throws Exception {
        Calendar first = Calendar.getInstance();
        Calendar second = Calendar.getInstance();
        second.setTime(secondDate);
        first.setTime(firstDate);

        first.set(Calendar.HOUR_OF_DAY, 0);
        first.set(Calendar.MINUTE, 0);
        first.set(Calendar.SECOND, 0);
        second.set(Calendar.HOUR_OF_DAY, 0);
        second.set(Calendar.MINUTE, 0);
        second.set(Calendar.SECOND, 0);


        //得到两个日期相差的天数
        long days = (second.getTimeInMillis() - first.getTimeInMillis()) / (1000*3600 * 24);
        return days;
    }

    public static List<String> getDayList(final  Date start,final Date end){
        List<String> strings=new ArrayList<String>();
        Calendar calendar =Calendar.getInstance();
        Calendar calendar2 =Calendar.getInstance();
        calendar.setTime(start);
        calendar2.setTime(end);
        SimpleDateFormat sdf =new SimpleDateFormat("MMdd");
        while (calendar2.compareTo(calendar)>=0){
            strings.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DATE,1);
        }
        return  strings;
    }
    
    public static List<String> getDayList2(final  Date start,final Date end){
      List<String> strings=new ArrayList<String>();
      Calendar calendar =Calendar.getInstance();
      Calendar calendar2 =Calendar.getInstance();
      calendar.setTime(start);
      calendar2.setTime(end);
      SimpleDateFormat sdf =new SimpleDateFormat("MM-dd");
      while (calendar2.compareTo(calendar)>=0){
        strings.add(sdf.format(calendar.getTime()));
        calendar.add(Calendar.DATE,1);
      }
      return  strings;
    }
    
    public static List<String> getWeekList(final  Date start,final Date end){
      List<String> strings=new ArrayList<String>();
      Calendar calendar =Calendar.getInstance();
      Calendar calendar2 =Calendar.getInstance();
      calendar.setTime(start);
      calendar2.setTime(end);
      int w = 0;
      SimpleDateFormat sdf =new SimpleDateFormat("MM-dd");
      while (calendar2.compareTo(calendar)>=0){
        int weeks = calendar.get(Calendar.WEEK_OF_YEAR)-1;
        if(w!=weeks){
          strings.add(String.valueOf(weeks));
        }
        w = weeks;
        calendar.add(Calendar.DATE,1);
      }
      return  strings;
    }
    
    public static List<String> getMonthList(final  Date start,final Date end){
      List<String> strings=new ArrayList<String>();
      Calendar calendar =Calendar.getInstance();
      Calendar calendar2 =Calendar.getInstance();
      calendar.setTime(start);
      calendar2.setTime(end);
      SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM");
      String s = "";
      while (calendar2.compareTo(calendar)>=0){
        if(!s.equals(sdf.format(calendar.getTime()))){
          strings.add(sdf.format(calendar.getTime()));
        }
        s = sdf.format(calendar.getTime());
        calendar.add(Calendar.DATE,1);
      }
      return  strings;
    }

    //检查logDate是否是当天
    public static boolean isToDay(Date logDate) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar log = Calendar.getInstance();
        log.setTime(logDate);
        return (log.before(now) && now.get(Calendar.YEAR) == log.get(Calendar.YEAR)
                && now.get(Calendar.DAY_OF_YEAR) == log.get(Calendar.DAY_OF_YEAR));
    }

    public static String utf8Encode(String value) {
        String result = null;
        if (value != null) {
            try {
                result = new String(value.getBytes("ISO-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /** 比较两个日期相差的月数 */
    public static int compareMonth(Date date1, Date date2) {
        if (date1 == null || date2 == null)
            return 0;

        int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);

            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);

            if (objCalendarDate2.equals(objCalendarDate1))
                return 0;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }

            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12 + objCalendarDate2.get(Calendar.MONTH) - flag) - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }

    public static Date addDate(Date date, String type, int addNum) {
        if (date == null)
            return null;

        if (type == null || type.trim().equals(""))
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (type.equals("1")) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + addNum);
        } else if (type.equals("2")) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + addNum);
        } else if (type.equals("3")) {
            calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + addNum);
        } else if (type.equals("4")) {
            calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR_OF_DAY) + addNum);
        } else if (type.equals("5")) {
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + addNum);
        }

        return calendar.getTime();
    }

    public static boolean isValidDate(String str) {
        try {
            parseDate(str, parsePatterns);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 传入时间格式为‘yyyy-MM-dd HH:mm:ss’字符串，将其转换成Date后返回
     * @param date
     * @return
     */
    public static Date parseStringDate(String date){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
    
	/**
	 * 将字符型数字转为Date类型
	 * 
	 * @param value
	 *            要转换的字符
	 * @return Date类型的日期
	 * @throws ParseException
	 */
	public static java.util.Date stringToDate(String dateString, String dateFormat) {
		if (dateString != null && dateString.trim().length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat,
					Locale.getDefault());
			try {
				Date date = sdf.parse(dateString);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws Exception {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	System.out.println(sdf.format(new Date()));
    	System.out.println(stringToDate("20141030133525","yyyyMMddHHmmss"));
//    	System.out.println(parseStringDate(System.currentTimeMillis()+""));
//        System.out.println(getDifDay(org.apache.commons.lang3.time.DateUtils.parseDate("2016-07-01","yyyy-MM-dd"),
//                org.apache.commons.lang3.time.DateUtils.parseDate("2016-03-07","yyyy-MM-dd")));
    }
}
