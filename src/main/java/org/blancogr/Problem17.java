package org.blancogr;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by blancogr on 1/10/17.
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then
 *  there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
 * how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Problem17 {
    public static void main(String[] args) {
        mine();
        theirs();

    }

    public static void mine() {
        long sum = 0;
        RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(Locale.UK, RuleBasedNumberFormat.SPELLOUT);
        //formatter.setDefaultRuleSet();
        //System.out.println(formatter.format(134));

        //Integer[] numbers = {1, 2, 342, 115, 201, 305, 407, 637, 801, 999, 1000};
        List<Integer> numbers = IntStream.range(100, 1000).boxed().collect(toList());

/*
        for(Integer i : numbers) {
            StringBuffer letters = new StringBuffer(formatter.format(i).replace(" ", "").replace("-", ""));
            // Add an "and"
            if(i > 100 && i != 1000 && i % 100 != 0) {
                letters.append("and");
            }
            sum += letters.toString().length();
            System.out.println(letters.toString() + " " + letters.toString().length());
        }

        System.out.println(sum);
*/


        for(int x = 1; x <= 1000; x++) {
            StringBuffer letters = new StringBuffer(formatter.format(x).replace(" ", "").replace("-", ""));
            // Add an "and"
            if(x > 100 && x != 1000 && x % 100 != 0) {
                letters.append("and");
            }
            sum += letters.toString().length();
        }
        System.out.println(sum);


    }

    public static void theirs() {
        int onetonine = "onetwothreefourfivesixseveneightnine".length();
        int tentonineteen = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
        int and = "and".length();
        int twentytoninety = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
        int hundred = "hundred".length();
        int thousand = "thousand".length();

        long count = "one".length() + thousand +
            900*hundred + 100*onetonine +
            100*twentytoninety + 891*and +
            80*onetonine + 10*(onetonine + tentonineteen);
        System.out.println(count);
    }
}
