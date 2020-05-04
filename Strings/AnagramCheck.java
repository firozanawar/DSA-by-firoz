package Strings;

import java.util.Arrays;

public class AnagramCheck {

    public static void main(String[] args) {
        //System.out.println("is isAnagram : " + isAnagram("army", "mary"));
        //System.out.println("is isAnagram : " + iAnagram("army", "mary"));
        System.out.println("is isAnagram : " + checkAnagram("army", "mary"));
    }

    public static boolean isAnagram(String word, String anagram) {
        if (word.length() != anagram.length())
            return false;

        char[] wordChar = word.toCharArray();
        for (char c : wordChar) {
            int index = anagram.indexOf(c);
            System.out.println("index: " + index);

            if (index != -1) {
                System.out.println("anagram string is: " + anagram);
                System.out.println("substring(0,index): " + anagram.substring(0, index) + " , substring(index+1): " + anagram.substring(index + 1));
                anagram = anagram.substring(0, index) + anagram.substring(index + 1);
            } else {
                return false;
            }
        }
        return anagram.isEmpty();
    }

    /* * Another way to check if two Strings are anagram or not in Java * This method assumes that both
    word and anagram are not null and lowercase * @return true, if both Strings are anagram. */
    public static boolean iAnagram(String word, String anagram) {
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        return Arrays.equals(charFromWord, charFromAnagram);
    }

    public static boolean checkAnagram(String first, String second) {
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
        for (char ch : characters) {
            int index = sbSecond.indexOf("" + ch);
            System.out.println("index: " + index);
            if (index != -1) {
                System.out.println("deleteCharAt: " + sbSecond.toString());
                sbSecond.deleteCharAt(index);

            } else {
                return false;
            }
        }
        return sbSecond.length() == 0 ? true : false;
    }


}
