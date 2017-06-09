package org.blancogr;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by blancogr on 1/24/17.
 * <p>
 * Using names.txt , a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its
 * alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name
 * in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 *
 * Solution: 871198282
 */

public class Problem22 {

    public static void main(String[] args) {
        System.out.println(rankNames(null));
    }

    public static Integer rankNames(String[] maybe) {
        Integer DELTA = 64;
        int sum = 0;

        List<String> names = entireFile(maybe);

        for (int index = 0; index < names.size(); index++) {
            String name = names.get(index);
            int letterValues = name.chars()
                .map(character -> character - DELTA)
                .sum();
            System.out.println("Name: " + name + ", letterValues: " + letterValues + " " + index);
            int nameScore = letterValues * (index + 1);
            System.out.println(nameScore);
            sum += nameScore;
            System.out.println(sum);
        }

        return sum;
    }

    public static List<String> entireFile(String[] given) {
        String FILENAME =
            "/Users/blancogr/git/personal/EulerJava/src/main/java/org/blancogr/Problem22Names.txt";
        List<String> toReturn = null;

        if (given == null) {
            try {
                toReturn = Files.readAllLines(Paths.get(FILENAME)).stream().collect(toList());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            toReturn = Arrays.asList(given);
        }

        List<String> names = toReturn.stream().map(name -> name.replace("\"", ""))
            .map(line -> line.split(",")).flatMap(Arrays::stream).sorted().collect(toList());

        return names;
    }
}
