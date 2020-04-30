package Arrays;

public class FindSecondLargestNumberInTheArray {

    public static void main(String[] args) {

        int[] arr1 = {9,7, 5, 6, 1, 4, 2};
        System.out.println(findSecondLargest(arr1));
    }

    private static int findSecondLargest(int arr[]) {

        int highest = Integer.MIN_VALUE;
        int secHighest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > highest) {

                secHighest = highest;
                highest = arr[i];
            }else if(arr[i] > secHighest && arr[i]!=highest){
                secHighest = arr[i];
            }
        }

        return secHighest;
    }
}
