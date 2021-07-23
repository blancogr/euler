package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import java.util.stream.LongStream;

/**
 * Created by blancogr on 1/9/17.
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Solution: 233168
 */
public class Problem1 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem 1");
        long result = LongStream.range(1, 1000).reduce(0, (a, b) -> {
            if (b % 3 == 0 || b % 5 == 0) {
                return a + b;
            }
            return a;
        });
        m.stop();
        System.out.println(result);
        System.out.println(m);
    }
}
