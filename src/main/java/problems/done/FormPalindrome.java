package problems.done;

public class FormPalindrome {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            char arr[] = sc.next().toCharArray();
            System.out.println(getMinimumNumberOfMoveForPalindrome(arr, 0, arr.length - 1));
        }
        */
        String str = "ab";
        System.out.println(getMinimumNumberOfMoveForPalindrome(str.toCharArray(), 0, str.toCharArray().length - 1));
        System.out.println(getMinimumNumberOfMoveForPalindromeByDP(str.toCharArray()));
    }

    public static int getMinimumNumberOfMoveForPalindrome(char arr[], int start, int end) {
        if (start < end) {
            if (arr[start] == arr[end]) {
                return getMinimumNumberOfMoveForPalindrome(arr, start + 1, end - 1);
            } else {
                return 1 + Math.min(getMinimumNumberOfMoveForPalindrome(arr, start + 1, end), getMinimumNumberOfMoveForPalindrome(arr, start, end - 1));
            }
        }
        return 0;
    }

    public static int getMinimumNumberOfMoveForPalindromeByDP(char arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int l = 0; l < arr.length; l++) {
            for (int j = 0; j < arr.length - l; j++) {
                if (l == 0) {
                    dp[j][j] = 0;
                } else {
                    if (arr[j] == arr[j + l]) {
                        dp[j][j + l] = dp[j + 1][j + l - 1];
                    } else {
                        dp[j][j + l] = 1 + Math.min(dp[j][j + l - 1], dp[j + 1][j + l]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }

    private static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
