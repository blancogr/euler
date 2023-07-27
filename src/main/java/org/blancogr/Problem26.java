package org.blancogr;

import java.util.stream.IntStream;

import static java.lang.Math.log;

/**
 * A unit fraction contains 1 in the numerator.
 * The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 *  1/2	= 	0.5
 *  1/3	= 	0.(3)
 *  1/4	= 	0.25
 *  1/5	= 	0.2
 *  1/6	= 	0.1(6)
 *  1/7	= 	0.(142857)
 *  1/8	= 	0.125
 *  1/9	= 	0.(1)
 *  1/10	= 	0.1
 *  Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
 *  It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 *  Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 *  in its decimal fraction part.
 *
 *  Algorithm:
 *  3 kinds of rational numbers:
 *  Terminating (1/4 = 0.25) -> those numbers are of the form 2^a * 5^b
 *  Repeating from the "." (1/7 = 0.(142857) -> those are coprime with 10 (no factors in common except 1)
 *  Repeating after some str (1/14 = 0.0(714285)) -> those are both of the above
 *
 *  So,
 *  1. gather non-kind-1
 *  2. pass those gather non-kind-2
 *  3.
 *  2.
 */


public class Problem26 {
    public static void main(String[] args) {
        mine();
    }

    public static void theirs() {
        System.out.println("--------------------------------------------");
        Double phi = (1 + Math.sqrt(5)) / 2;
        Double lowerBound = (999 * log(10) + log(5) / 2) / log(phi);
        System.out.println("Result (theirs) is: " + Math.round(lowerBound));
    }

    public static void mine() {
        IntStream.range(1, 20)
            .map(it -> {
                boolean kind1 = isKind1(1.0/it);
                System.out.println("" + 1.0/it + " " + kind1);
                return 0;
            }).sum();

    }

    public static boolean isKind1(double n) {
        // is n of the form 2^a * 5^b
        if (n % 2 != 0 || n % 5 != 0) {
            return false;
        }
        return true;
    }
    // 376
}
