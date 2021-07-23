package org.blancogr;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by blancogr on 3/28/17.
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * Answer: 2783915460
 */
public class Problem24 {
    public static void main(String[] args) {

        ArrayList<String> buffer = new ArrayList<>();
        perm1("", "0123456789", buffer);

        List<String> sorted = buffer.stream().sorted().collect(toList());

        System.out.println(sorted.get(999999));
    }

    private static void perm1(String prefix, String s, ArrayList<String> buffer) {
        int n = s.length();
        if (n == 0) {
            //System.out.println(prefix);
            buffer.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n), buffer);
        }
    }
}
