package Strings;

public class ReverseString {

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        reverseString.reverseUsingRecursion("Welcome");

        reverseString("The sky is blue");
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

    private static void reverseString(String s) {

        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
