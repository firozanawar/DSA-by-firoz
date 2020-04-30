package Arrays;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumber {

    public static void main(String[] args) {

        int[] arr1 = {7, 5, 6, 1, 4, 2};
        //int[] arr1={5,3,1,2};

        int length = arr1.length + 1; // 1 for missing element count
        int sum = 0;

        int totalSum = (length * (length + 1)) / 2;

        for (int i = 0; i < arr1.length; i++) {
            sum += arr1[i];
        }

        System.out.println("Missing element is: " + (totalSum - sum));

        findMissingNumUsingBitSet(arr1, 7);
    }

    /**
     *  For more one or more than number missing
     * @param arr
     * @param count
     */
    private static void findMissingNumUsingBitSet(int[] arr, int count) {
        int missingCount = count - arr.length;
        BitSet bitSet = new BitSet(count);

        for (int number : arr) {
            bitSet.set(number - 1);
        }

        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }
}
