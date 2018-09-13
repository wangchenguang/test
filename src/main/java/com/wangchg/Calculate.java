package com.wangchg;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author wangchenguang
 * @version 1.0
 * @date 2018/9/13
 */
public class Calculate {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(calendar.getTime());
        System.out.println(time);
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
