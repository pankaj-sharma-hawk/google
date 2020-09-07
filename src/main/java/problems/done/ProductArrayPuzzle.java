package problems.done;

import java.util.Arrays;

public class ProductArrayPuzzle {

    public static void main(String[] args) {
        int arr[] = {10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(getProductArrayPuzzle(arr)));
    }

    public static int[] getProductArrayPuzzle(int arr[]) {
        int dp[] = new int[arr.length];
        int dp2[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            dp2[i] = 1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            dp[i + 1] = dp[i] * arr[i];
        }
        for (int i = arr.length - 1; i > 0; i--) {
            dp2[i - 1] = dp2[i] * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            dp[i] = dp[i] * dp2[i];
        }
        return dp;
    }


}
