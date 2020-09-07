package problems.array;

import java.util.*;

public class Sum2 {

    public static void main(String[] args) {
        int arr[] = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        Arrays.sort(arr);
        System.out.println(getAllSum3(arr, 0, arr.length - 1, 0));
    }

    public static List<List<Integer>> getAllSum3(int arr[], int start, int end, int targetSum) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = start; i <= end; i++) {
            List<List<Integer>> response = getAllSum2(arr, i + 1, end, arr[i], targetSum);
            if (!response.isEmpty()) {
                addElementToAllList(response, arr[i]);
                result.addAll(response);
            }
        }
        return new ArrayList<>(result);
    }

    private static void addElementToAllList(List<List<Integer>> lists, int element) {
        for (List<Integer> list : lists) {
            list.add(element);
        }
    }

    private static List<List<Integer>> getAllSum2(int arr[], int start, int end, int prevSum, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        while (start < end) {
            if (prevSum + arr[start] + arr[end] == targetSum) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[start]);
                list.add(arr[end]);
                result.add(list);
                start++;
                end--;
            } else if (prevSum + arr[start] + arr[end] > targetSum) {
                end--;
            } else {
                start++;
            }

        }
        return result;
    }
}
