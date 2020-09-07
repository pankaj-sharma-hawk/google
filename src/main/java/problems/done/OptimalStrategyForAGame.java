package problems.done;

import java.util.Scanner;

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getOptimalStrategy(arr));
        }
    }

    public static int getOptimalStrategy(int arr[]) {
        int dp[][] = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < arr.length + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return getMaximumValue(arr, 0, arr.length - 1, dp);
    }

    private static int getMaximumValue(int[] arr, int i, int j, int dp[][]) {
        if (i == j)
            return arr[i];
        if (j == i + 1)
            return Math.max(arr[i], arr[j]);
        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = Math.max(arr[i] + Math.min(getMaximumValue(arr, i + 1, j - 1, dp), getMaximumValue(arr, i + 2, j, dp)),
                arr[j] + Math.min(getMaximumValue(arr, i, j - 2, dp), getMaximumValue(arr, i + 1, j - 1, dp)));
        return dp[i][j];
    }


}
