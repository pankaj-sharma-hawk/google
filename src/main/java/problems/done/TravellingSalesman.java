package problems.done;

import java.util.Scanner;

public class TravellingSalesman {

    public static void main(String[] args) {
/*        int cost[][] = {{0, 1000, 5000}, {5000, 0, 1000}, {1000, 5000, 0}};
        System.out.println(calculateTravellingSalesmanCost(cost, cost.length));*/
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int arr[][] = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(calculateTravellingSalesmanCost(arr, size));
        }
    }

    public static int calculateTravellingSalesmanCost(int cost[][], int size) {
        boolean visited[] = new boolean[size];
        totalTravelCost = Integer.MAX_VALUE;
        visited[0] = true;
        tsp(cost, visited, 0, size, 0);
        return totalTravelCost;
    }

    private static int totalTravelCost = 0;

    private static void tsp(int cost[][], boolean[] visited, int source, int size, int travelCost) {
        boolean isValueChanges = false;
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                if ((travelCost + cost[source][i]) < totalTravelCost) {
                    isValueChanges = visited[i] = true;
                    tsp(cost, visited, i, size, travelCost + cost[source][i]);
                    visited[i] = false;
                }
            }

        }
        if (!isValueChanges && isAllVertexVisted(visited)) {
            totalTravelCost = Math.min(totalTravelCost, travelCost + cost[source][0]);
        }

    }

    private static boolean isAllVertexVisted(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

}
