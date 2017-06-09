package org.blancogr;


import java.util.stream.LongStream;

/**
 * Created by blancogr on 1/10/17.
 * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * <p>
 * Result should be 142913828922
 */
public class Problem10 {
    public static void main(String[] args) {

        long result = LongStream.range(2, 2000000)
                .boxed()
                .filter(EulerUtils::isPrime)
                .mapToLong(n -> n)
                .sum();

        System.out.println(result);
    }
}
