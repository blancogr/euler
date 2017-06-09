package org.blancogr;

/**
 * Created by blancogr on 1/10/17.
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * Left, left, down, down
 * Left, down, left, down
 * Left, down, down, left
 * Down, left, left, down
 * Down, left, down, left
 * Down, down, left, left
 *
 * How many such routes are there through a 20×20 grid?
 *
 * https://en.wikipedia.org/wiki/Binomial_coefficient#Multiplicative_formula
 *
 * Answer: 137846528820
 *
 */

public class Problem15 {
    public static void main(String[] args) {
        int gridSize = 20;
        long paths = 1L;

        // Binomial coefficient implementation, multiplicative formula.
        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }

        System.out.println(paths);

    }
}
