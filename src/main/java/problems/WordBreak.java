package problems;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "ab";
        Map<String, Boolean> map = new HashMap<>();
        map.put("a", true);
        map.put("b", true);
        // getWordBreak(s, map);
        WordBreak obj = new WordBreak();
        System.out.println(obj.getWordBreak(s, map));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return getWordBreak(s, getHashMap(wordDict));
    }

    private Map<String, Boolean> getHashMap(List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word : wordDict) {
            map.put(word, true);
        }
        return map;
    }


    public List<String> getWordBreak(String str, Map<String, Boolean> dic) {
        resultList = new HashSet<>();
        List<String> list = new ArrayList<>();
        getWordBreakUtil(str, 0, 0, str.length(), list, dic, false);
        List<String> wordResultList = new ArrayList<>();

        for (List<String> word : resultList) {
            StringJoiner sb = new StringJoiner(" ");
            Collections.reverse(word);
            for (String s : word) {
                sb.add(s);
            }
            wordResultList.add(sb.toString());
        }
        return wordResultList;
    }

    private static Set<List<String>> resultList = new HashSet<>();

    private void getWordBreakUtil(String str, int fromIndex, int currentIndex, int size, List<String> bucket, Map<String, Boolean> dic, boolean isFound) {
        if (currentIndex > str.length()) {
            if (isFound)
                resultList.add(bucket);
            return;
        }
        for (int i = currentIndex; i <= size; i++) {
            if (dic.containsKey(str.substring(fromIndex, i))) {
                List<String> tempList = getWordList(str.substring(fromIndex, i));
                tempList.addAll(bucket);
                getWordBreakUtil(str, i, i + 1, size, tempList, dic, true);
                getWordBreakUtil(str, fromIndex, i + 1, size, bucket, dic, false);
            }
        }
    }

    private List<String> getWordList(String word) {
        List<String> list = new ArrayList<>();
        list.add(word);
        return list;
    }

}
