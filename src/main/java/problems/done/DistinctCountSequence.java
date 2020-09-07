package problems.done;

import java.util.Scanner;

public class DistinctCountSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(countDistinctSequence(a.toCharArray(), b.toCharArray()));
        }
    }

    public static int countDistinctSequence(char a[], char b[]) {
        int dp[][] = new int[b.length + 1][a.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < b.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < b.length + 1; i++) {
            for (int j = i; j < a.length + 1; j++) {
                if (b[i - 1] == a[j - 1]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[b.length][a.length];
    }
}
