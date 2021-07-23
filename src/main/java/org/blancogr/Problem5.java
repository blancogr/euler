package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * Created by blancogr on 1/9/17.
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * The answer should be 232792560
 */
public class Problem5 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem5");

        for(int i = 2521; i < Integer.MAX_VALUE; i++) {
            boolean isResult = true;
            for(int mult = 2; mult <=20; mult++) {
                if(i % mult != 0) {
                    isResult = false;
                    break;
                }
            }

            if(isResult) {
                System.out.println(i);
                break;
            }
        }

        m.stop();
        System.out.println(m);
    }
}
