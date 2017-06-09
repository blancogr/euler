package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

import java.util.List;

/**
 * Created by blancogr on 1/9/17.
 * <p>
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * <p>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * <p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 * <p>
 * Solution: 4613732
 */
public class Problem2 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem2");
        List<Long> fibs = EulerUtils.fibUpTo(4000000L);
        Long sum = fibs.stream().filter(x -> x % 2 == 0).reduce(0L, (a, b) -> a + b);
        m.stop();
        System.out.println(sum);
        System.out.println(m.toString());
    }

}