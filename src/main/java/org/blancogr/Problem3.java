package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.blancogr.tdd.EulerUtils;

import java.math.BigInteger;
import java.util.List;


/**
 * Created by blancogr on 1/9/17.
 * <p>
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * <p>
 * Result should be 6857
 */
public class Problem3 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem 3");
        BigInteger top = new BigInteger("600851475143");
        List<BigInteger> factors = EulerUtils.primeFactors(top);
        m.stop();

        System.out.println(factors.stream().max(BigInteger::compareTo).orElseGet(() -> BigInteger.valueOf(-1L)));
        System.out.println(m);
    }
}
