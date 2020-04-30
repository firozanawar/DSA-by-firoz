package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static void main(String[] args) {

        int [] arr = {10, 20, 30, 40, 50};
        //reverseM1(arr, arr.length);
        //reverseM2(arr, arr.length);

        Integer [] arr1 = {10, 20, 30, 40, 50};
        reverseM3(arr1);
    }

    /* function that reverses array and stores it
       in another array*/
    static void reverseM1(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        /*printing the reversed array*/
        System.out.println("Reversed array is: \n");
        for (int k = 0; k < n; k++) {
            System.out.println(b[k]);
        }
    }

    /*function swaps the array's first element with last element,
      second element with last second element and so on*/
    static void reverseM2(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

        /*printing the reversed array*/
        System.out.println("Reversed array is: \n");
        for (k = 0; k < n; k++) {
            System.out.println(a[k]);
        }
    }

    static void reverseM3(Integer a[])
    {
        Collections.reverse(Arrays.asList(a));
        System.out.println(Arrays.asList(a));
    }
}
