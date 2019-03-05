package org.blancogr;

import org.blancogr.tdd.EulerUtils;

/**
 * Created by blancogr on 1/21/17.
 */
public class Problem20 {
    public static void main(String... args) {
        System.out.println(sumOfFactorials(100));
    }

    public static String sumOfFactorials(int max) {

        int sum = EulerUtils.factorial(max).toString().chars().map(Character::getNumericValue)
            .reduce(0, (a, b) -> a + b);

        return String.valueOf(sum);
    }
}
