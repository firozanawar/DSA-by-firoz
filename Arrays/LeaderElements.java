package Arrays;

public class LeaderElements {

    public static void main(String[] args) {

        int[] array = {16, 17, 4, 3, 5, 2};
        //findLeaders(array);
        findLeadersM2(array,array.length);
    }

    private static void findLeaders(int arr[]) {

        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j])
                    break;
            }
            if (j == arr.length) // the loop didn't break
                System.out.print(arr[i] + " ");
        }

    }

    private static void findLeadersM2(int arr[], int size) {

        int max_from_right = arr[size - 1];

        /* Rightmost element is always leader */
        System.out.print(max_from_right + " ");

        for (int i = size - 2; i >= 0; i--) {
            if(max_from_right < arr[i]){
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }

    }
}
