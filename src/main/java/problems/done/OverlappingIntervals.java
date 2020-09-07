package problems.done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OverlappingIntervals {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int size = sc.nextInt();
            List<Pair> pairList = new ArrayList<>();
            while (size-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                pairList.add(new Pair(x, y));
            }
            Collections.sort(pairList, (pair1, pair2) -> pair1.x == pair2.y ? 0 : (pair1.x > pair2.x ? 1 : -1));
            System.out.println(getOverLapedList(pairList));
        }
    }

    private static List<Integer> getOverLapedList(List<Pair> sortedPair) {
        if (sortedPair == null || sortedPair.isEmpty()) {
            return new ArrayList<>();
        }
        int x = sortedPair.get(0).x;
        int y = sortedPair.get(0).y;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 1; i < sortedPair.size(); i++) {
            if (sortedPair.get(i).x <= y) {
                y = sortedPair.get(i).y;
            } else {
                resultList.add(x);
                resultList.add(y);
                x = sortedPair.get(i).x;
                y = sortedPair.get(i).y;
            }
        }
        resultList.add(x);
        resultList.add(y);
        return resultList;
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
