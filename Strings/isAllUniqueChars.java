package Strings;

public class isAllUniqueChars {

    public static void main(String[] args) {

        //System.out.println("isUnique: " + isUniqueM1("abcdefgh"));
        System.out.println("isUnique: " + isUniqueM2("xyz"));
    }

    /**
     * Without using any Data structure
     * <p>
     * Time - O(n2)
     * Space - O(1)
     */
    private static boolean isUniqueM1(String str) {
        boolean isUnique = true;

        for (int i = 0; i < str.length(); i++) {

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    isUnique = false;
                }
            }
        }
        return isUnique;
    }

    /**
     * Time - O(n)
     * Space - O(1)
     */
    private static boolean isUniqueM2(String str) {

        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            System.out.println("str.charAt(i): " + val);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
