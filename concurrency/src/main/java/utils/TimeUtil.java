package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    /**
     * 时间格式
     */
    public static final String yyyyMMddHHmmss="yyyy-MM-dd HH:mm:ss";

    public static String getTimeString(Date date, String format ){
        String timeString = new SimpleDateFormat(format).format(date);
        return timeString;
    }

    public static String getCurrentTime(){
        return TimeUtil.getTimeString(new Date(),TimeUtil.yyyyMMddHHmmss);
    }
}
