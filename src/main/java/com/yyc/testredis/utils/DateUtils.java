package com.yyc.testredis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateUtils {

    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    public static final String DD_MM_YYYY = "dd/MM/yyyy";

    public static final String YYYY_MM_DD = "yyyy.MM.dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String TIME_PATTERN = "HH:mm";

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";


    /**
     * 根据日期格式，返回日期按DEFAULT_FORMAT格式转换后的字符串
     *
     * @param aDate 日期对象
     * @return 格式化后的日期的页面显示字符串
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(DEFAULT_FORMAT);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    public static final String parseToDateTimeStr(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(DATE_TIME_PATTERN);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis(); // smdate
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis(); // bdate
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e) {

            logger.info("Exception:",e);
            throw new RuntimeException(e);
        }
    }


    public static int getMonth(Date smdate, Date bdate) throws ParseException {

        int result = 0;

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(smdate);
        c2.setTime(bdate);

        result = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }

    public static int monthBetween(Date smdate, Date bdate) throws ParseException {
        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(smdate);
        c2.setTime(bdate);

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result;

    }

    /**
     * 按照日期格式，将字符串解析为日期对象
     *
     * @param aMask
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (logger.isDebugEnabled()) {
            logger.debug("converting '" + strDate + "' to date with mask '"
                    + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            logger.info("ParseException:",pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * @param theTime
     * @return
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * @return
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_FORMAT);

        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * @param aMask
     * @param aDate
     * @return
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 根据日期格式，返回日期按DEFAULT_FORMAT格式转换后的字符串
     *
     * @param aDate
     * @return
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(DEFAULT_FORMAT, aDate);
    }

    /**
     * 按照日期格式，将字符串解析为日期对象
     *
     * @param strDate (格式 yyyy-MM-dd)
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
            throws ParseException {
        Date aDate = null;

        try {
            if (logger.isDebugEnabled()) {
                logger.debug("converting date with pattern: " + DEFAULT_FORMAT);
            }

            aDate = convertStringToDate(DEFAULT_FORMAT, strDate);
        } catch (ParseException pe) {
            logger.error("Could not convert '" + strDate
                    + "' to a date, throwing exception");
            logger.info("ParseException:",pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());

        }

        return aDate;
    }

    /**
     * 时间相加
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date addHour(Date date, int hour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    /**
     * 月相加
     *
     * @param date
     * @param month
     * @return
     */
    public static Date addMonth(Date date, int month) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static int getDay(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 本年的第一天
     */
    public static String getYearFirst(Integer year) {
        return formatDate(getCurrYearFirst(year));
    }

    /**
     * 本年的最后一天
     *
     * @param year
     * @return
     */
    public static String getYearLast(Integer year) {
        return formatDate(getCurrYearLast(year));
    }

    public static Integer getYear() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy");
        String year = f.format(date);
        return Integer.valueOf(year);

    }

    /**
     * @param date
     * @return yyyy-MM-dd
     */
    public static String formatDate(Date date) {
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }

    public static String formatDate(String formatPattern, Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat f = new SimpleDateFormat(formatPattern);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static Date preciseToDayFull(Date d) {
        String day = getDateTime(DEFAULT_FORMAT, d);//yyyy-MM-dd 格式转换成字符串
        try {
            return convertStringToDate(DEFAULT_FORMAT, day);
        } catch (Exception e) {

            logger.info("Exception:",e);
            return null;
        }
    }

    /**
     * 一天的第一时刻，即 yyyy-MM-dd 00:00:00
     *
     * @param d
     * @return
     */
    public static Date theDayFirstTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 一天的最后时刻，即 yyyy-MM-dd 23:59:59
     *
     * @param d
     * @return
     */
    public static Date theDayLastTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return Date
     */
    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }


    public static String getLastDay() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, -1); //
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        logger.info(s);

        return s;

    }

    /**
     * 获取本月日期
     *
     * @return
     */
    public static String[] findMonthDate() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        String startDate = format.format(calendar.getTime());
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        String endDate = format.format(calendar.getTime());
        String[] monthDate = {startDate, endDate};
        return monthDate;
    }

    /**
     * 得到上月1号到月底日期
     *
     * @return
     */
    public static String[] findLastMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_prevM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_prevM).append(
                " 00:00:00");
        day_first_prevM = str.toString();

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.DATE, -1);
        String day_end_prevM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(
                " 23:59:59");
        day_end_prevM = endStr.toString();

        String[] map = {day_first_prevM, day_end_prevM};
        return map;
    }

    /**
     * 得到上周一到周日日期
     *
     * @return
     */
    public static String[] getLastWeekDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] day = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.add(Calendar.WEEK_OF_MONTH, -1);
        day[0] = sdf.format(cal.getTime());
        cal.set(Calendar.DAY_OF_WEEK, 2);
        day[1] = sdf.format(cal.getTime());
        return day;
    }

    /**
     * 得到本周一到周日日期
     *
     * @return String[] 0 本周一 1 本周日
     */
    public static String[] getWeekDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] day = new String[2];
        Calendar c = Calendar.getInstance();
        int dayofweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0) {
            dayofweek = 7;
        }
        c.add(Calendar.DATE, -dayofweek + 1);
        day[0] = sdf.format(c.getTime());
        int dayweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayweek == 0) {
            dayweek = 7;
        }
        c.add(Calendar.DATE, -dayweek + 7);
        day[1] = sdf.format(c.getTime());

        return day;
    }

    /**
     * 计算连续天数
     *
     * @param days
     * @return
     */
    public static int calContinueDays(List<Date> days) {
        int continueDay = 0;
        Date lDay = null;
        for (Date day : days) {
            if (lDay != null) {
                if (!isContinueDay(day, lDay)) {
                    return continueDay;
                }
            }
            lDay = day;
            continueDay++;
        }
        return continueDay;
    }

    public static boolean isContinueDay(Date preDay, Date curDay) {
        String d1 = formatDate(addDay(preDay, 1));
        String d2 = formatDate(curDay);

        return d1.equals(d2);
    }

    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }
    /**
     * 获取指定格式的日期字符串
     * @param format 传入的日期格式
     * @return
     */
    public static String getNowDateByFormat(String format){
        Calendar c=Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(c.getTime());
    }

    public static String formatDateTime(long minutes) {
        String DateTimes = null;
        long days = minutes / ( 60 * 24);
        long hours = (minutes % ( 60 * 24)) / 60;
        minutes = minutes % 60;
        if(days>0){
            DateTimes= days + "天" + hours + "小时" + minutes + "分钟";
        }else if(hours>0){
            DateTimes=hours + "小时" + minutes + "分钟";
        }else{
            DateTimes=minutes + "分钟";
        }
        return DateTimes;
    }
}
