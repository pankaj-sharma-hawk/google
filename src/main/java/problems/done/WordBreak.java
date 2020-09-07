package problems.done;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBreak {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
//        int t = Integer.parseInt(sc.nextLine());
        int t = 1;
        while (t-- > 0) {
//            int size = Integer.parseInt(sc.nextLine());
//            String words[] = sc.nextLine().split(" ");
//            String matchWord = sc.nextLine();

            System.out.println(isWordSetDP(new String[]{"I", "am", "ace", "a"}, "Iamace") ? 1 : 0);
        }
    }

    public static String wordBreak(String words, String matchWord) {
        Pattern pattern = Pattern.compile(".*" + matchWord + ".*");
        Matcher m = pattern.matcher(words);
        return m.find() ? "Yes" : "No";
    }

    /*   public static boolean isWordBreak(String words[], char arr[]) {
           int j = 0, k = 0;
           int temp = 0;
           do {
               temp = j;
               for (String word : words) {
                   char first[] = word.toCharArray();
                   j = k;
                   int i = 0;
                   for (; i < first.length && j < arr.length; i++) {
                       if (first[i] == arr[j]) {
                           j++;
                       } else {
                           break;
                       }
                   }
                   if (i == first.length) {
                       k = j;
                   }
                   if (k == arr.length)
                       break;
               }
           } while (temp != j);
           return arr.length == k ? true : false;
       }
   */
    public static boolean isWordBreak(String words[], String matchString) {
        Set<String> wordSet = getStringSet(words);
        boolean dp[][] = new boolean[matchString.length() + 1][matchString.length() + 1];
        return isWordBreak(wordSet, matchString, dp);
    }

    private static boolean isWordBreak(Set<String> wordSet, String matchString, boolean dp[][]) {
        if (matchString.isEmpty()) {
            dp[0][matchString.length()] = true;
        } else {

            for (int j = 0; j < matchString.length(); j++) {
                boolean result = wordSet.contains(matchString.substring(0, j + 1));
                if (result) {
                    dp[0][j + 1] = true;
                }
                if (result && isWordBreak(wordSet, matchString.substring(j + 1), dp)) {
                    return true;
                }
            }
        }
        return dp[0][matchString.length()];
    }

    private static Set<String> getStringSet(String words[]) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        return set;
    }

    public static boolean isWordSetDP(String words[], String matchString) {
        Set<String> wordsSet = getStringSet(words);
        boolean dp[][] = new boolean[matchString.length()][matchString.length()];
        int values[][] = new int[matchString.length()][matchString.length()];
        for (int l = 1; l <= matchString.length(); l++) {
            for (int i = 0; i <= matchString.length() - l; i++) {
                String subStringWord = matchString.substring(i, i + l);
                if (l == 1) {
                    if (wordsSet.contains(subStringWord)) {
                        dp[i][i] = true;
                    }
                } else {
                    dp[i][l - 1] = isWordFoundInDictionary(wordsSet, matchString, dp, i, i + l - 1);
                }
            }
        }
        return dp[0][matchString.length() - 1];
    }

    private static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isWordFoundInDictionary(Set<String> dictionary, String wordString, boolean dp[][], int start, int end) {
        for (int i = start; i <= end; i++) {
            if (dp[start][i] && dp[i + 1][end]) {
                return true;
            } else {
                System.out.println(start + " " + i + " " + end + " " + wordString.length() + " " + wordString);
                String secondSubString = wordString.substring(start, i + 1);
                String firstSubString = wordString.substring(i + 1, end + 1);
                if (secondSubString.length() == 0 && dictionary.contains(firstSubString) || firstSubString.length() == 0 && dictionary.contains(secondSubString)) {
                    return true;
                }
                if (dp[start][i] && dictionary.contains(firstSubString) || dictionary.contains(secondSubString) && dp[i + 1][end]) {
                    return true;
                }

            }
        }
        return false;
    }
}
