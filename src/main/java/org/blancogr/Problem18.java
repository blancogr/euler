package org.blancogr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by blancogr on 1/11/17.
 * <p>
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below:
 * <p>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * <p>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by
 * brute force, and requires a clever method! ;o)
 *
 * Answer: 1074
 */
public class Problem18 {

    public static void main(String[] args) {


        Integer[][] t = {
                                    {75},
                                 {95, 64},
                               {17, 47, 82},
                             {18, 35, 87, 10},
                           {20,  4, 82, 47, 65},
                         {19,  1, 23, 75,  3, 34},
                       {88,  2, 77, 73,  7, 63, 67},
                     {99, 65,  4, 28,  6, 16, 70, 92},
                   {41, 41, 26, 56, 83, 40, 80, 70, 33},
                 {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
               {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
             {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
           {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
         {63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        {4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}
        };

        List<List<Integer>> triangle = Arrays.stream(t).map(Arrays::asList).collect(toList());

        /*
        Integer[][] t = {
                    {1},
                   {10, 2},
                 {1, 10, 5},
                {1, 8, 10, 10},
              {1, 7, 10, 1, 0},
             {1, 1, 7, 10, 6, 1},
            {11, 1, 8, 10, 1, 2, 3}
        };
        List<List<Integer>> triangle = Arrays.stream(t).map(Arrays::asList).collect(toList());
        */

        getNextPoint(triangle);
    }

    public static Integer getNextPoint(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 1; row > 0; row--) {
            List<Integer> bottomRow = triangle.get(row);
            List<Integer> topRow = triangle.get(row - 1);
            List<Integer> newRow = new ArrayList<>();


            IntStream.range(0, topRow.size()).forEach(index -> {
                int n = topRow.get(index);
                int left = bottomRow.get(index);
                int right = bottomRow.get(index + 1);

                switch (Integer.compare(n + left, n + right)) {
                    case 1:
                        newRow.add(n + left);
                        break;
                    case 0:
                    case -1:
                        newRow.add(n + right);
                        break;
                    default:
                        System.out.println("SHOOOOT!");

                }
            });
            triangle.remove(row);
            triangle.remove(row - 1);
            triangle.add(new ArrayList<>(newRow));
            newRow.clear();
        }

        Integer result = triangle.stream().flatMap(Collection::stream).collect(toList()).get(0);
        System.out.println(result);
        return result;
    }
}

