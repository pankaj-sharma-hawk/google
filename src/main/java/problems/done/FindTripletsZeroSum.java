package problems.done;

import java.util.Arrays;

public class FindTripletsZeroSum {

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1};
        System.out.println(isTripleSumZero(arr, arr.length));
    }

    public static boolean isTripleSumZero(int arr[], int size) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end) {
                if ((arr[i] + arr[start] + arr[end]) == 0)
                    return true;
                if ((arr[i] + arr[start] + arr[end]) > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return false;
    }
}
