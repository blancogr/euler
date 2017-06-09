package org.blancogr;

import java.util.stream.LongStream;

/**
 * Created by blancogr on 1/10/17.
 * <p>
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 * The first ten terms would be:
 * <p>
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * <p>
 * Let us list the factors of the first seven triangle numbers:
 * <p>
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * <p>
 * We can see that 28 is the first triangle number to have over five divisors.
 * <p>
 * What is the value of the first triangle number to have over five hundred divisors?
 * <p>
 * Answer:
 * A formula to find the number of divisors by prime factorization. Given
 * <p>
 * n = x * x * y * y * y  (x, y are primes)
 * n = x^2 * y^3
 * <p>
 * The number of divisors is the multiplication of (exponents + 1). So,
 * <p>
 * divisors(n) = (2 + 1) * (3 + 1) = 12.
 * <p>
 * Example:
 * 48 = 2^4 * 3^1 => divisors(48) = 5 x 2 = 10.
 * <p>
 * Answer should be 12375 -> 76,576,500
 */
public class Problem12 {
    public static void main(String[] args) {
        LongStream.range(2L, Long.MAX_VALUE).sorted()
            .forEach(number -> {
                Long triangular = number * (number + 1) / 2;

                if(EulerUtils.numberOfPrimeDivisors(triangular) > 500) {
                    System.out.println("The number is " + number + " which triangular product is " + triangular);
                    System.exit(0);
                }
            });
/*
        // Using Longs
        Monitor m2 = MonitorFactory.start("Problem 2, take 2");
        LongStream.range(2L, Long.MAX_VALUE).sorted()
            .forEach(number -> {
                Map<Integer, List<Integer>> grouped =
                    EulerUtils.primeFactors(number).stream()
                        .collect(groupingBy(Function.identity()));

                Integer result = grouped.values().stream()
                    .map(List::size)
                    .reduce((left, right) -> (left + 1) * (right + 1))
                    .orElseGet(() -> 1);

                if (result > 500) {
                    System.out.println(number);
                    m2.stop();
                    System.out.println(m2.toString());
                    System.exit(0);
                }
            });
*/
    }
}
