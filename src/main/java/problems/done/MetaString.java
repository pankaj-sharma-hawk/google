package problems.done;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetaString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            System.out.println(isMetaString(sc.nextLine(), sc.nextLine()) ? 1 : 0);
        }
    }

    public static boolean isMetaString(String firstString, String secondString) {
        char arr1[] = firstString.toCharArray();
        char arr2[] = secondString.toCharArray();
        if (arr1.length != arr2.length) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                list.add(i);
            }
        }
        if (list.isEmpty() || list.size() > 2) {
            return false;
        }
        char temp = arr1[list.get(0)];
        arr1[list.get(0)] = arr1[list.get(1)];
        arr1[list.get(1)] = temp;
        return new String(arr1).equals(new String(arr2));
    }
}
