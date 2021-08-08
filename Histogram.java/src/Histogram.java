/**
 * @name Histogram.java
 * @author Jacob Ortiz
 * @date 1/29/20
 * sorts array by letter, and then displays occurrences
 * updated to do all letters
 */

import java.io.*;
import java.util.*;

public class Histogram {

    private static HashMap<Character, Integer> letter = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        letter.put('A', 0);
        letter.put('B', 0);
        letter.put('C', 0);
        letter.put('D', 0);
        letter.put('E', 0);
        letter.put('F', 0);
        letter.put('G', 0);
        letter.put('H', 0);
        letter.put('I', 0);
        letter.put('J', 0);
        letter.put('K', 0);
        letter.put('L', 0);
        letter.put('M', 0);
        letter.put('N', 0);
        letter.put('O', 0);
        letter.put('P', 0);
        letter.put('Q', 0);
        letter.put('R', 0);
        letter.put('S', 0);
        letter.put('T', 0);
        letter.put('U', 0);
        letter.put('V', 0);
        letter.put('W', 0);
        letter.put('X', 0);
        letter.put('Y', 0);
        letter.put('Z', 0);
        

        Scanner keyboard = new Scanner(System.in);
        System.out.println("input filename: ");
        String filename = keyboard.nextLine();

        File f = new File(filename);
        Scanner finput = new Scanner(f);

        StringBuilder line = new StringBuilder();

        while (finput.hasNextLine()) {
            line.append(finput.nextLine());
        }

        // compares HashMap to char array and updates the occurrences
        char [] string = line.toString().toCharArray();
        for(char key : string) {
            if(letter.containsKey(key)) {
                letter.put(key, letter.get(key) + 1);
            }
        }

        System.out.println("Char   Occurrences");

        for(Map.Entry<Character, Integer> only_counts : letter.entrySet()) {
            if(only_counts.getValue() > 0) {
                System.out.printf(" %s          %d\n", only_counts.getKey(), only_counts.getValue());
            }
        }

        Map<Character, Integer> sorted = sortByValue(letter);

        System.out.println("\n============= Vertical Bar =============");
        int max = Collections.max(letter.values());

        for(int i = max; i > 0; i--) {
            System.out.printf("|%3d | ", i);

            for(Map.Entry<Character, Integer> stars : sorted.entrySet()) {
                if(stars.getValue() >= i) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        System.out.println("========================================");
        System.out.print("| No |  ");
        for(Map.Entry<Character, Integer> chars : sorted.entrySet()) {
            System.out.print(chars.getKey() + "  ");
        }

        System.out.println("\n========================================");

    }

    // function to sort the values in hashmap
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> HM) {

        List<Map.Entry<Character, Integer >> list = new LinkedList<>(HM.entrySet());

        // sorting
        list.sort(Map.Entry.comparingByValue());

        // return the sorted hashmap!
        HashMap<Character, Integer> result = new LinkedHashMap<>();

        for(Map.Entry<Character, Integer> index : list) {
            result.put(index.getKey(), index.getValue());
        }

        return result;
    }
}
