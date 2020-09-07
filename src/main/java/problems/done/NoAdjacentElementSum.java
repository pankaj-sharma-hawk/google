package problems.done;

public class NoAdjacentElementSum {
    public static void main(String[] args) {
        int arr[] = {5, 5, 10, 100, 10, 5};
        System.out.println(maxSumNoAdjecentElementWithSpace(arr));
    }

    public static int maxSumNoAdjecentElement(int arr[]) {
        int dp[][] = new int[2][arr.length];
        dp[0][0] = arr[0];
        dp[1][0] = 0;
        int incl = 0, excl = 0;
        for (int i = 1; i < arr.length; i++) {
            incl = dp[0][i - 1];
            excl = dp[1][i - 1];
            dp[0][i] = arr[i] + excl;
            dp[1][i] = Math.max(incl, dp[1][i]);
        }
        return Math.max(dp[0][arr.length - 1], dp[1][arr.length - 1]);
    }

    public static int maxSumNoAdjecentElementWithSpace(int arr[]) {
        int incl = 0, excl = 0;
        incl = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = temp;
        }
        return Math.max(incl, excl);
    }
}
