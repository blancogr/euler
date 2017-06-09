package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import java.math.BigInteger;

/**
 * Created by blancogr on 1/10/17.
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * Answer: 1366
 */

public class Problem16 {
    public static void main(String[] args) {
        // The JDK is saving something because when I revert the two tests, I get the second (whichever
        // that might be) faster than the first.

        Monitor monitor = null;
        Monitor monitor2 = null;

        /*for(int i = 0; i < 1000000; i++) {
            monitor2 = MonitorFactory.start("pow");
            BigInteger bi = BigInteger.valueOf(2);
            //String hugeNumber = bi.shiftLeft(1000).toString();
            String hugeNumber = bi.pow(1000).toString();
            long sum = hugeNumber.chars().map(Character::getNumericValue)
                .asLongStream().sum();
            //System.out.println(sum);
            monitor2.stop();
        }
        System.out.println(monitor2.toString());
        */
        /*
        /Results:
        JAMon Label=shiftLeft, Units=ms.: (LastValue=0.0, Hits=1000000.0, Avg=0.012831, Total=12831.0,
            Min=0.0, Max=53.0, Active=0.0, Avg Active=1.0, Max Active=1.0, First Access=Tue Jan 10 23:01:29 MST 2017,
            Last Access=Tue Jan 10 23:01:42 MST 2017)

        JAMon Label=pow, Units=ms.: (LastValue=0.0, Hits=1000000.0, Avg=0.013802, Total=13802.0, Min=0.0,
            Max=52.0, Active=0.0, Avg Active=1.0, Max Active=1.0, First Access=Tue Jan 10 23:00:14 MST 2017,
            Last Access=Tue Jan 10 23:00:28 MST 2017)
        */

        for(int i = 0; i < 1000000; i++) {
            monitor = MonitorFactory.start("shiftLeft");
            BigInteger bi = BigInteger.ONE;
            String hugeNumber = bi.shiftLeft(1000).toString();
            //String hugeNumber = bi.pow(1000).toString();
            long sum = hugeNumber.chars().map(Character::getNumericValue)
                .asLongStream().sum();
            //System.out.println(sum);
            monitor.stop();
        }
        System.out.println(monitor.toString());


    }
}
