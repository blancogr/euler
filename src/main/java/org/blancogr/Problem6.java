package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * Created by blancogr on 1/9/17.
 *
 * The sum of the squares of the first ten natural numbers is
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Notes:
 *
 * the sum of squares is a square pyramidal number.
 *   See https://en.wikipedia.org/wiki/Square_pyramidal_number and https://oeis.org/A000330.
 *
 * The formula for square pyramidal numbers is
 *
 *   n(n + 1)(2n + 1)
 *   ----------------
 *         6
 *
 * The sum of 1..n is (n(n+1) / 2)
 *
 * The result should be 25164150 (sumOfSq = 338350, sqOfSum = 25502500)
 *
 */
public class Problem6 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem6");

        Long sumOfSq = (long) (100 * (100 + 1) * ((2 * 100) + 1) / 6);

        long sum = (long) 100 * (100 + 1) / 2;
        Long sqOfSum = sum * sum;

        System.out.println(sqOfSum - sumOfSq);

        m.stop();
        System.out.println(m.toString());
    }
}
