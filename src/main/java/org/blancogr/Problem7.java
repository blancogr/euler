package org.blancogr;

/**
 * Created by blancogr on 1/9/17.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * Methods to determine primality (see https://en.wikipedia.org/wiki/Primality_test):
 *
 * 1. Trial division. Simplest but computationally intensive.
 *     For an input n, test that n / 2..sqrt(n) always gives a remainder. If there's a remainder == 0, the number is NOT prime.
 *
 * 2. Test remainder for 2 and 3. Then, test remainder for n / p where p is all numbers (6k +- 1) < sqrt(n), and k = integers
 *
 * The answer is 104743
 */
public class Problem7 {
    public static void main(String[] args) {
        int count = 1;
        for(long i = 2; i < Long.MAX_VALUE; i++) {
            if(EulerUtils.isPrime(i)) {
                if(count == 10001) {
                    System.out.println(i);
                    break;
                }
                count++;
            }
        }
    }
}
