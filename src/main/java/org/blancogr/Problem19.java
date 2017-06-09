package org.blancogr;

import org.apache.commons.lang3.Validate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by blancogr on 1/21/17.
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September, April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 *
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */

public class Problem19 {
    public static void main(String... args) {
        countSundays("1901-01-01", "2000-12-31");
    }

    public static Integer countSundays(String fromStr, String toStr) {
        Validate.notNull(fromStr);
        Validate.notNull(toStr);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

            Calendar from = Calendar.getInstance();
            from.setTime(sdf.parse(fromStr));

            Calendar to = Calendar.getInstance();
            to.setTime(sdf.parse(toStr));

            int count = 0;
            while (from.compareTo(to) < 0) {
                from.add(Calendar.MONTH, 1);
                if (from.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    count++;
                }
            }
            System.out.println("Result: " + count);
            return count;
        } catch (Exception e) {
            System.out.println("Ooops... \n"+ e);
            System.exit(1);
        }
        return -1;
    }
}
