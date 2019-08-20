package utils;

import constant.DateDelayUnitEnum;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期工具类
 *
 * @author: fengzhihang
 * @create: 2019-07-15 12:37
 **/
public class DateUtil {

    // 默认日期格式
    private static final String DEFAULT_DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat DEFAULT_SIMPLEDATEFORMAT = new SimpleDateFormat(DEFAULT_DATE_FORMATE);

    /**
     * 字符串转date
     *
     * @param dateString 格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate(String dateString) throws ParseException {
        return DEFAULT_SIMPLEDATEFORMAT.parse(dateString);
    }

    /**
     * 按照指定格式转为Date
     *
     * @param dateString 日期字符串
     * @param format 格式
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dateString, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(dateString);
    }

    /**
     * 日期时间转字符串
     *
     * @param date Date
     * @return 日期时间字符串(yyyy-MM-dd HH:mm:ss)
     */
    public static String dateTimeToString (Date date) {
        return dateTimeToString(date, DEFAULT_DATE_FORMATE);
    }

    /**
     * 日期时间转字符串
     *
     * @param date Date
     * @param format 日期时间字符串格式
     * @return 日期时间字符串
     */
    public static String dateTimeToString(final Date date, final String format) {
        if (date != null) {
            final SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
        return null;
    }

    /**
     * 计算从开始时间的左右时间
     *
     * @param startDate 开始时间
     * @param delay 左右时间
     * @param unit 时间单位
     * @return Date 计算后的时间
     */
    public static Date getAfterDate(Date startDate, Integer delay, DateDelayUnitEnum unit){
        if(null == startDate || null == delay) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        switch (unit) {
            case YEAR:
                calendar.add(Calendar.YEAR, delay);
                break;
            case MONTH:
                calendar.add(Calendar.MONTH, delay);
                break;
            case DAY:
                calendar.add(Calendar.DAY_OF_MONTH, delay);
                break;
            case HOUR:
                calendar.add(Calendar.HOUR_OF_DAY, delay);
                break;
            case MINUTE:
                calendar.add(Calendar.MINUTE, delay);
                break;
            case SECOND:
                calendar.add(Calendar.SECOND, delay);
                break;
        }
        return calendar.getTime();
    }

    /**
     * 获取参数日期的今日开始时间
     *
     * @param date
     * @return
     */
    public static Date getDayStartTime(Date date){
        return getDateAnyTime(date, "00:00:00");
    }

    /**
     * 获取参数日期的今日结束时间
     *
     * @param date
     * @return
     */
    public static Date getDayEndTime(Date date){
        return getDateAnyTime(date, "23:59:59");
    }


    /**
     * 获取一日的任何时间
     *
     * @param date 日期
     * @param time 时间 格式：00:00:00
     * @return
     */
    public static Date getDateAnyTime(Date date, String time) {
        String dataString = DEFAULT_SIMPLEDATEFORMAT.format(date);
        String startString = dataString.substring(0, 11) + time;
        Date result = null;
        try {
            result = DEFAULT_SIMPLEDATEFORMAT.parse(startString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return result;

    }

    public static void main(String[] args) {
        Date date = DateUtil.getAfterDate(new Date(), 10, DateDelayUnitEnum.SECOND);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = simpleDateFormat.format(date);
        System.out.println(s);
    }

}