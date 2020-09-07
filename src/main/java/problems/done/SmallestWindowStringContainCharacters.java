package problems.done;

import java.util.HashMap;
import java.util.Map;
//asbbcccdddefkc
//asbbcccdddefkc
public class SmallestWindowStringContainCharacters {
    public static void main(String[] args) {
        String word = "sdfsdakjfsasbbcccdddefkcjkg";
        String pattern = "abbccccdd";
        System.out.println(getSmallestWindowOfMatchingPattern(word.toCharArray(), pattern.toCharArray()));
    }

    public static String getSmallestWindowOfMatchingPattern(char word[], char pattern[]) {
        int leftIndex = 0;
        int rightIndex = 0;
        int minimumWindow = Integer.MAX_VALUE;
        String result = "";
        while (rightIndex < word.length) {
            if ((rightIndex - leftIndex + 1) >= pattern.length && isPatternMatch(word, leftIndex, rightIndex, pattern)) {
                if (minimumWindow > (rightIndex - leftIndex + 1)) {
                    minimumWindow = rightIndex - leftIndex + 1;
                    result = getString(word, leftIndex, rightIndex);
                }
                leftIndex++;
            } else {
                rightIndex++;
            }
        }
        return result;
    }

    public static String getSmallestWindowOfMatchingPatternDP(char word[], char pattern[]) {
        int patternLength = pattern.length;
        Map<Character, Integer> map = getFrequencyMap(pattern);
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String resultString = "";
        while (right < word.length) {
            if (map.get(word[right]) != null) {
                if (map.get(word[right]) > 0)
                    patternLength--;
                map.put(word[right], map.get(word[right]) - 1);

            }
            right++;
            while (patternLength == 0) {
                if (minLength > (right - left)) {
                    minLength = right - left;
                    resultString = getString(word, left, right - 1);
                }
                if (map.get(word[left]) != null) {
                    map.put(word[left], map.getOrDefault(word[left], 0) + 1);
                    if (map.get(word[left]) > 0) {
                        patternLength++;
                    }
                }
                left++;
            }

        }
        if ("".equals(resultString))
            return "-1";
        return resultString;
    }

    private static Map<Character, Integer> getFrequencyMap(char arr[]) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    private static boolean isPatternMatch(char word[], int start, int end, char pattern[]) {
        int freq[] = new int[26];
        for (int i = start; i <= end; i++) {
            freq[word[i] - 'a']++;
        }
        for (int i = 0; i < pattern.length; i++) {
            if (freq[pattern[i] - 'a'] == 0)
                return false;
            freq[pattern[i] - 'a']--;
        }
        return true;

    }

    private static String getString(char word[], int left, int right) {
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(word[left++]);
        }
        return sb.toString();
    }
}
