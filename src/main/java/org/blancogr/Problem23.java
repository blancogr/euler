package org.blancogr;

import org.blancogr.tdd.EulerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * Created by blancogr on 1/24/17.
 *
 * A perfect number is a number for which the sum of its proper divisors is exactly
 * equal to the number. For example, the sum of the proper divisors of 28 would be
 * 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers is
 * less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as
 * the sum of two abundant numbers.
 */

public class Problem23 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        theirs(); // 1645 milliseconds
        mine(); // 134566 milliseconds
        System.out.println(System.currentTimeMillis() - start);

    }

    private static void mine() {
        int last = 28123;

        List<Long> digits = new ArrayList<>();

        for(long x = 0; x < last; x++) {
            digits.add(x);
        }

        List<Integer> abundant = new ArrayList<>();
        for(int y = 11; y < last; y++) {
            if(isAbundant2(y)) {
                abundant.add(y);
            }
        }

        long count = 0;
        for(int x = 0; x < abundant.size(); x++) {
            for (Integer integer : abundant) {
                long sum = abundant.get(x) + integer;

                int index = digits.indexOf(sum);
                if (index != -1) {
                    digits.remove(index);
                }
                count++;
            }
            //System.out.print(".");
        }
        System.out.println(count);
        System.out.println(digits.stream().mapToLong(x -> x).sum());
    }

    private static void theirs() {
        int last = 28123;

        List<Integer> abundants = new ArrayList<>();

        for(int i = 1; i < last; i++) {
            int sumOfFactors = EulerUtils.factorsList(i).stream().mapToInt(x -> x).sum();

            if(sumOfFactors > i) {
                abundants.add(i);
            }
        }

        Boolean[] digits = new Boolean[(28123 * 2) + 1];
        Arrays.fill(digits, Boolean.FALSE);

        long count = 0;
        for(int i = 0; i < abundants.size(); i++) {
            for(int j = 0; j <= i; j++) {
                digits[abundants.get(i) + abundants.get(j)] = true;
                count++;
            }
        }

        int sum = 0;
        for(int i = 0; i < 30000; i++) {
            if(!digits[i]) {
                sum += i;
            }
        }
        System.out.println(count);
        System.out.println(sum);

    }

    private static boolean isAbundant(long n) {
        Optional<List<Long>> factors = EulerUtils.factors(n);

        if(factors.isPresent()) {
            List<Long> them = factors.get();
            long sum = them.stream().mapToLong(x -> x).sum();
            return sum > n;
        }
        return false;
    }

    private static boolean isAbundant2(int i) {
        int sumOfFactors = EulerUtils.factorsList(i).stream().mapToInt(x -> x).sum();

        return sumOfFactors > i;
    }

    private static boolean isAbundant3(int i) {
        return IntStream.range(1, i / 2).filter(x -> i % x == 0).sum() > i;
    }
}
