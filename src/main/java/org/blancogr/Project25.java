package org.blancogr;

import com.sun.prism.shader.Solid_TextureFirstPassLCD_AlphaTest_Loader;

import java.math.BigInteger;

import static java.lang.Math.log;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 *      Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * Answer = 4782
 *
 * Now, this is a mathematician's explanation:
 *
 * Saying that a number contains 1000 digits is the same as saying that it's greater than 10^999.
 *
 * The nth Fibonacci number is [phi^n / sqrt(5)], where the brackets denote "nearest integer".
 *
 * So we need
 *
 * phi^n/sqrt(5) > 10^999
 *
 * n * log(phi) - log(5)/2 > 999 * log(10)
 *
 * n * log(phi) > 999 * log(10) + log(5)/2
 *
 * n > (999 * log(10) + log(5) / 2) / log(phi)
 *
 * A handheld calculator shows the right hand side to be
 * 4781.8593, so 4782 is the first integer n with the
 * desired property.
 *
 * Implemented below
 */
public class Project25 {
    public static void main(String[] args) {
        mine();
        theirs();
    }

    public static void mine() {
        BigInteger minusOne = new BigInteger("1");
        BigInteger minusTwo = new BigInteger("1");


        Long index = 3L; // because the first two numbers are set
        while(true) {
            BigInteger newNumber = minusOne.add(minusTwo);
            if(newNumber.toString().length() < 1000) {
                minusTwo = minusOne;
                minusOne = newNumber;
                index++;
            } else {
                System.out.println("Result (mine) is: " + index);
                return;
            }
        }
    }

    public static void theirs() {
        Double phi = (1 + Math.sqrt(5)) / 2;
        Double lowerBound = (999 * log(10) + log(5) / 2) / log(phi);
        System.out.println("Result (theirs) is: " + Math.round(lowerBound));
    }
}
