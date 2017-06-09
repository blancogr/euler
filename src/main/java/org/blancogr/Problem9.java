package org.blancogr;

/**
 * Created by blancogr on 1/10/17.
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 *   a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * The answer should be a = 200, b = 375, c = 425, with product 31875000
 *

 */
public class Problem9 {
    public static void main(String[] args) {
        for(int a = 1; a <= 1000; a++) {
            for(int b = 1; b <= 1000; b++) {
                for(int c = 1; c <= 1000; c++) {
                    if(((a * a) + (b * b) == c * c) && (a + b + c == 1000)) {
                        System.out.println(String.format(
                                "The triplet is %d, %d, %d, with product %d", a, b, c, (a * b * c)));
                        System.exit(0);
                    }

                }
            }
        }

    }
}
