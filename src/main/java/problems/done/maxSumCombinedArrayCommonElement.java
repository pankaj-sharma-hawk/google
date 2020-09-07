package problems.done;

public class maxSumCombinedArrayCommonElement {

    public static void main(String[] args) {
        // Array is Sorted Array
        int arr1[] = {1, 7, 8, 9, 11, 13, 15, 18, 20, 32};
        int arr2[] = {4, 5, 8, 10, 12, 13, 14, 20, 25, 30, 35};
        System.out.println(getMaxSum(arr1, arr2));
    }

    public static int getMaxSum(int arr1[], int arr2[]) {
        int part1Sum = 0, part2Sum = 0, totalSum = 0, i = 0, j = 0;
        for (; i < arr1.length && j < arr2.length; ) {
            if (arr1[i] == arr2[j]) {
                totalSum += Math.max(part1Sum + arr1[i++], part2Sum + arr2[j++]);
                part1Sum = part2Sum = 0;
            } else {
                if (arr1[i] < arr2[j]) {
                    part1Sum += arr1[i++];
                } else {
                    part2Sum += arr2[j++];
                }
            }

        }
        totalSum += Math.max(part1Sum, part2Sum);
        if (i == arr1.length && j != arr2.length) {
            return totalSum + getRemainingSum(arr2, j);
        } else if (i != arr1.length && j == arr2.length) {
            return totalSum + getRemainingSum(arr1, i);
        }
        return totalSum;

    }

    private static int getRemainingSum(int arr[], int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


}
