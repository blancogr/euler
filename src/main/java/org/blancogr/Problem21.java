package org.blancogr;


import java.util.*;

/**
 * Created by blancogr on 1/22/17.
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called
 * amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * Solution: 10000
 */
public class Problem21 {
    public static void main(String[] args) {
        System.out.println(getAmicable(1, 9999));
    }

    public static Integer getAmicable(int min, int max) {
        Map<Integer, Integer> factorsMap = makeMap(min, max);

        List<Integer> amicableNumbers = new ArrayList<>();

        for(Integer key1 : factorsMap.keySet()) {
            // The vars below are just to make the problem easy to read
            Integer value1 = factorsMap.get(key1);
            Integer key2 = value1;
            Integer value2 = factorsMap.get(key2);

            if(Objects.equals(key1, value2) && !Objects.equals(key1, value1)) {
                amicableNumbers.add(key1);
            }
        }
        System.out.println(amicableNumbers);
        return amicableNumbers.stream().reduce(0, (a,b) -> a + b);
    }

    public static Map<Integer, Integer> makeMap(long min, long max) {
        Map<Integer, Integer> mapOfFactors = new HashMap<>();

        for (Long i = min; i <= max; i++) {
            List<Long> factors = (List<Long>) EulerUtils.factors(i).get();
            int sumOfFactors = factors.stream().mapToInt(Long::intValue).sum();
            mapOfFactors.put(i.intValue(), sumOfFactors);
        }
        return mapOfFactors;
    }
}
