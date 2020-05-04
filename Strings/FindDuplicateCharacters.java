package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindDuplicateCharacters {

    public static void main(String[] args) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
    }

    public static void printDuplicateCharacters(String word) {
        if (word.isEmpty()) return;

        char[] characters = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : characters) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> enteries = map.entrySet();
        System.out.printf("List of duplicate characters in String '%s' %n",word);
        for (Map.Entry<Character, Integer> entry : enteries) {
            if (entry.getValue() > 1) {
                System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
            }
        }
    }
}
