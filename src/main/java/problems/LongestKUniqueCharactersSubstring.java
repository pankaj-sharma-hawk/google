package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestKUniqueCharactersSubstring {

    public static void main(String[] args) {
        String word = "aabacbebebe";
        int k = 3;
        System.out.println(getLongestUniqueCharacter(word.toCharArray(), k));
       /* Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String word = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine());
            System.out.println(getLongestUniqueCharacter(word.toCharArray(), k));
        }*/
    }

    public static int getLongestUniqueCharacter(char arr[], int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int unique = 0;
        int maxLength = Integer.MIN_VALUE;
        while (right < arr.length) {
            if (!map.containsKey(arr[right]) || map.get(arr[right]) == 0) {

                unique++;
                map.put(arr[right], 1);
            } else {
                map.put(arr[right], map.get(arr[right]) + 1);
            }
            while (unique > k) {
                maxLength = Math.max(maxLength, right - left);
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    unique--;
                }
                left++;
            }
            right++;
        }
        if (unique == k)
            maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }
}

