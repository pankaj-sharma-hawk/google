package problems.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

    public static List<List<Integer>> getDAGraph() {
        /*
         *               0           3
         *               |           |
         *              \|/         \|/
         *               |           |
         *               4----->>----5
         *               |           |
         *              \|/         \|/
         *               |           |
         *               6-----<<----7
         *               |           |
         *              \|/         \|/
         *               |           |
         *               1           2
         *
         *
         * */
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(4);
        graph.get(3).add(5);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(5).add(7);
        graph.get(7).add(6);
        graph.get(7).add(2);
        graph.get(6).add(1);
        return graph;
    }

    public static void printGraph(List<List<Integer>> graph) {
        int v = 0;
        for (List<Integer> vertex : graph) {
            for (Integer e : vertex) {
                System.out.println(v+"-->"+e);
            }
            v++;
        }
    }
}
