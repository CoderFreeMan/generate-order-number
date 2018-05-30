package generateordernumber.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p> Date             :2017/10/28 </p>
 * <p> Module           : </p>
 * <p> Description      : </p>
 * <p> Remark           : </p>
 *
 * @author yangdejun
 * @version 1.0
 * <p>--------------------------------------------------------------</p>
 * <p>修改历史</p>
 * <p>    序号    日期    修改人    修改原因    </p>
 * <p>    1                                     </p>
 */
public class DateUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String NUMBER_DATE_FORMAT = "yyyyMMdd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    //14位时间格式 yyyyMMddHHmmss
    public static final String DATETIME_14 = "yyyyMMddHHmmss";
    public static final String DATE_YYYYMM = "yyyyMM";

    //19位时间格式 yyyyMMddHHmmss
    public static final String DATETIME_19 = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {}

    /**
     * @param time
     * @return
     */
    public static long getTime(String time) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
        Date timeDate = null;
        try {
            timeDate = format.parse(time);
        } catch (ParseException e) {
            LOGGER.error("getTime is error: ", e);
        }
        if (null != timeDate) {
            return timeDate.getTime();
        }
        return 0L;
    }

    /**
     * @param date
     * @return
     */
    public static long getTime(Date date) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);
        Date timeDate = null;
        try {
            timeDate = timeFormat.parse(timeFormat.format(new Date()));
        } catch (ParseException e) {
            LOGGER.error("getTime is error: {},date is {}", e, date);
        }
        if (null != timeDate) {
            return timeDate.getTime();
        }
        return 0L;
    }

    /**
     * @param date1
     * @param date2
     * @return
     */
    public static long subDays(Date date1, Date date2) {
        long d1 = toDate(formatDateToDefaultString(date1), DEFAULT_DATE_FORMAT).getTime();
        long d2 = toDate(formatDateToDefaultString(date2), DEFAULT_DATE_FORMAT).getTime();
        return (d1 - d2) / (1000 * 60 * 60 * 24);
    }

    /**
     * @param d
     * @return
     */
    public static String formatDateToDefaultString(Date d) {
        Date date = d;
        SimpleDateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return df.format(date);
    }

    /**
     * @param d
     * @return
     */
    public static String formatDateToYYYYMMDDString(Date d) {
        Date date = d;
        SimpleDateFormat df = new SimpleDateFormat(NUMBER_DATE_FORMAT);
        return df.format(date);
    }

    /**
     * @param date
     * @param format
     * @return
     */
    public static String formatDateToString(Date date, String format) {
        Date timeDate = date;
        String pattern = format;
        if (timeDate == null) {
            timeDate = new Date();
        }
        if (StringUtils.isBlank(pattern)) {
            pattern = DEFAULT_DATE_FORMAT;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(timeDate);
    }

    /**
     * @see DateUtils#toDate(String, String)
     */
    public static Date toDefaultDate(String dateStr) {
        return toDate(dateStr, DEFAULT_DATE_FORMAT);
    }

    /**
     * @param dateStr
     * @param format
     * @return
     */
    public static Date toDate(String dateStr, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 返回当前时间戳
     *
     * @param format 默认为：yyyyMMddHHmmss
     * @return string 时间字符串
     * @author huanghui
     * @see [类、类#方法、类#成员]
     */
    public static String getCurrentTimestamp(final String format) {
        String defaultFormat = format;
        if (StringUtils.isBlank(defaultFormat)) {
            defaultFormat = DATETIME_14;
        }
        return formatDateToString(new Date(), defaultFormat);
    }

    /**
     * 获取本月总天数
     *
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 转换字符串为Date
     *
     * @param dateStr 要转换的时间字符串
     * @param format  时间格式
     * @return Date 时间类型结果
     */
    public static Date formatStringToDate(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        if (StringUtils.isEmpty(format)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
            if (!dateStr.equals(df.format(date))) {
                date = null;
            }
        } catch (ParseException e) {
            LOGGER.error("formatStringToDate is error: ", e);
        }
        return date;
    }
}
