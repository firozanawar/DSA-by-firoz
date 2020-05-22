package Strings;

public class ReverseString {

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        reverseString.reverseUsingRecursion("Welcome");
    }

    private void reverseUsingRecursion(String str) {
        String s = reverseRecursive(str);
        System.out.println("s: " + s);
    }

    private String reverseRecursive(String str) {
        System.out.println("str: " + str);
        if (str.isEmpty()) return str;
        return reverseRecursive(str.substring(1)) + str.charAt(0);

    }
}
