package sorting;

public class SelectionSort {

    public static void main(String[] args) {

        int[] a = {36, 19, 29, 12, 5, 7, 1, 99};

        int temp = 0,min_index;
        for (int i = 0; i < a.length; i++) {

             min_index = i;
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[min_index]){ // or a[j] > a[i]
                    min_index = j;
                }
            }

            // swap here
            temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
