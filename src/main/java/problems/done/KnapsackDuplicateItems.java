package problems.done;

import java.util.Scanner;

public class KnapsackDuplicateItems {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int weight[] = new int[n];
            int values[] = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                weight[i] = sc.nextInt();
            }
            System.out.println(getMaximumValueByWeight(weight, values, w));
        }
    }

    public static int getMaximumValueByWeight(int weight[], int values[], int totalWeight) {
        int dp[] = new int[totalWeight + 1];
        for (int i = 1; i <= totalWeight; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i >= weight[j]) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + values[j]);
                }
            }
        }
        return dp[totalWeight];
    }
}
