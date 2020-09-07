package problems.notdone;

public class ThePainterPartitionProblem {
    public static void main(String[] args) {
//        int board[] = {10, 20, 30, 40, 50, 60, 20, 30, 50, 10};
//        int board[] = {10, 20, 30, 30, 20, 10, 10, 20, 30, 10};
//        int board[] = {10, 10, 10, 10};
//        int board[] = {10, 20, 30, 40};
//        int board[] = {83, 173, 135};
        int board[] = {274, 465, 130, 135, 254, 45, 70, 122, 149, 95, 453, 65, 392, 331, 316, 484, 372, 339, 45, 46, 31, 167, 351, 415, 387, 275, 355, 440, 290, 462, 436, 416, 279, 66, 403, 33, 464, 473, 8, 113, 420, 461, 30, 312};
        int k = 26;
        System.out.println(getMinimumTime(board, k, board.length));
       /* Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getMinimumTime(arr, k, n));

        }*/
    }

    public static int getMinimumTime(int board[], int numberOfPainter, int boardSize) {
        int eachPartitionSize[][] = new int[numberOfPainter][3];
        int index = 0;
        int fromIndex = 0, toIndex = -1;
        int partition = 0;
        while (boardSize > 0) {
            fromIndex = toIndex + 1;
            partition = boardSize / numberOfPainter;
            toIndex = fromIndex + partition - 1;
            eachPartitionSize[index][0] = fromIndex;
            eachPartitionSize[index][1] = toIndex;
            index++;
            boardSize -= partition;
            numberOfPainter--;
        }
        index = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < board.length; i++) {
            currentSum += board[i];
            if (eachPartitionSize[index][1] == i) {
                eachPartitionSize[index][2] = currentSum;
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
                currentSum = 0;
                index++;
            }
        }
        boolean isModified = true;
        int endSize = board.length;
        while (isModified) {
            isModified = false;
            int newMax = eachPartitionSize[0][2];
            for (int i = 1; i < endSize; i++) {
                int tempSum = eachPartitionSize[i - 1][2] + board[eachPartitionSize[i][0]];
                if (eachPartitionSize[i][0] != eachPartitionSize[i][1] && tempSum <= maxSum) {
                    eachPartitionSize[i - 1][2] = tempSum;
                    eachPartitionSize[i - 1][1]++;
                    eachPartitionSize[i][0]++;
                    int prevSum = eachPartitionSize[i][2];
                    eachPartitionSize[i][2] -= board[eachPartitionSize[i - 1][1]];
                    isModified = true;
                    newMax = Math.max(Math.max(newMax, eachPartitionSize[i][2]), eachPartitionSize[i - 1][2]);
                    if (prevSum == maxSum) {
                        maxSum = Math.max(eachPartitionSize[i][2], newMax);
//                        endSize = i;
                    }
                } else {
                    newMax = Math.max(newMax, eachPartitionSize[i][2]);
                }
            }
            maxSum = isModified ? newMax : maxSum;
        }
        return maxSum;
    }
}
