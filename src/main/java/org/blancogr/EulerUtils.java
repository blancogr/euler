package org.blancogr;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Hello world!
 */
public class EulerUtils {

    static List<Long> fibUpTo(Long n) {
        List<Long> fibs = new ArrayList<>();
        Long a = 0L, b = 1L, c = 1L;

        while (c < n) {
            c = a + b;
            a = b;
            b = c;
            fibs.add(c);
        }
        return fibs;

    }

    static Boolean isPrime(Long number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        int n = 5;
        while (n * n <= number) {
            if (number % n == 0 || number % (n + 2) == 0) return false;
            n += 6;
        }
        return true;
    }

    static List<BigInteger> primeFactors(BigInteger n) {
        List<BigInteger> factors = new ArrayList<>();
        BigInteger n2 = n, i = new BigInteger("2");

        while (i.compareTo(n2) < 1) {
            if (Objects.equals(n2.mod(i), BigInteger.ZERO)) {
                factors.add(i);
                n2 = n2.divide(i);
            } else {
                i = i.add(BigInteger.ONE);
            }
        }
        return factors;
    }

    static List<Long> primeFactors(Long number) {
        List<Long> factors = new ArrayList<>();

        Long n = number;

        for (Long i = 2L; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    static List<Integer> factorsList(Integer n) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);

        if (n % 2 == 0 && n != 2) factors.add(2);

        double upToIncluding = n / 2;
        for (Integer i = 3; i <= upToIncluding; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    static Optional factors(Long n) {
        List<Long> factors = new ArrayList<>();
        factors.add(1L);

        if (n % 2 == 0 && n != 2) factors.add(2L);

        double upToIncluding = n / 2;
        for (Long i = 3L; i <= upToIncluding; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return Optional.of(factors);
    }

    static Integer numberOfPrimeDivisors(Long n) {
        Map<Long, List<Long>> divisors = primeFactors(n).stream().collect(groupingBy(Function.identity()));

        Optional<Integer> numDivisors =
            divisors.values().stream().map(l -> l.size() + 1).reduce((a, b) -> a * b);

        return numDivisors.orElse(0);
    }

    static BigInteger factorial(Integer n) {
        return IntStream.range(1, n)
            .asLongStream()
            .boxed()
            .map(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
