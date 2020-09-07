package problems.done;

public class FindlargestWordDictionary {

    public static void main(String[] args) {
        String dict[] = new String[]{"pintu", "geeksfor", "geeksgeeks",
                " forgeek"};
        String word = "geeksforgeeks";
        System.out.println(getLargeWordInDictionary(dict, word));
    }

    public static String getLargeWordInDictionary(String dic[], String word) {
        int maxValue = Integer.MIN_VALUE;
        String result = null;
        for (int i = 0; i < dic.length; i++) {
            if (dic[i].length() < maxValue)
                continue;
            int matchingCount = countMatchingLetter(dic[i].toCharArray(), 0, word.toCharArray(), 0, 0);
            if (matchingCount > maxValue) {
                maxValue=matchingCount;
                result = dic[i];
            }
        }
        return result;
    }

    public static int countMatchingLetter(char a[], int startA, char b[], int startB, int count) {
        if (startA == a.length || startB == b.length) {
            return count;
        }
        if (a[startA] == b[startB]) {
            count++;
            startB++;
            startA++;
        }else{
            startB++;
        }
        return countMatchingLetter(a, startA, b, startB, count);

    }
}
