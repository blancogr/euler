package org.blancogr;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

/**
 * Created by blancogr on 1/9/17.
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * The result should be numbers 993 and 913, that multiplied make 906609
 */
public class Problem4 {
    public static void main(String[] args) {
        Monitor m = MonitorFactory.start("Problem4");
        int n1 = 0, n2 = 0, product = 0;
        for(int i = 2; i < 999; i++) {
            for(int j = 2; j < 999; j++) {
                int number = i * j;
                if(Integer.toString(number).equals(new StringBuilder(Integer.toString(number)).reverse().toString())
                        && i * j > product) {
                    n1 = i; n2 = j; product = i * j;
                }
            }
        }
        m.stop();
        System.out.println("N1: " + n1 + ", N2: " + n2 + " = " + product);
        System.out.println(m);

    }
}
