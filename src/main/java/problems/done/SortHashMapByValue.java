package problems.done;

import java.util.*;

public class SortHashMapByValue {

    public static void main(String[] args) {
        String str[] = {"hat", "cat", "mat", "net", "hat", "jat", "hat", "mat", "cat"};
        printcountTheFrequency(Arrays.asList(str));
    }

    public static void printcountTheFrequency(List<String> inputList) {
        Map<String, Integer> map = new HashMap<>();
        inputList.stream().forEach(word -> {
            map.put(word, map.getOrDefault(word, 0) + 1);
        });
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (firstEntry, secondEntry) -> {
            if (firstEntry.getValue() == secondEntry.getValue()) {
                return secondEntry.getKey().compareTo(firstEntry.getKey());
            }
            return firstEntry.getValue() > secondEntry.getValue() ? -1 : 1;
        });
        print(list);
    }

    private static void print(List<Map.Entry<String, Integer>> list) {
        list.stream().forEach(item -> {
            System.out.println(item.getKey() + " " + item.getValue());
        });
    }
}
