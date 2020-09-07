package problems.done;

public class Knapsack0_1 {

    public static void main(String[] args) {
        int weight[] = {1, 2, 3};
        int values[] = {10, 15, 40};
        int totalWeight = 6;
        System.out.println(maxProfitKnapsack(weight, values, totalWeight));
    }

    public static int maxProfitKnapsack(int weight[], int values[], int totalWeight) {
        int dp[][] = new int[weight.length + 1][totalWeight + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < totalWeight + 1; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= weight[i - 1]) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i][j]);
                }
            }
        }
        return dp[weight.length][totalWeight];
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }

    }
}
