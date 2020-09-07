package problems.done;

import problems.graph.GraphBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {

        List<List<Integer>> graph = GraphBuilder.getDAGraph();
        printTopologicalValues(getTopologicalSortedValue(graph));
    }

    public static Stack<Integer> getTopologicalSortedValue(List<List<Integer>> graph) {
        int selectedVertex = 0;
        Set<Integer> visitedVertex = new HashSet<>();
        Stack<Integer> topologicalSortedValues = new Stack<>();
        while ((selectedVertex = getUnvisitedVertex(graph, visitedVertex)) != -1) {
            dfs(graph, selectedVertex, visitedVertex, topologicalSortedValues);
        }
        return topologicalSortedValues;
    }

    private static void dfs(List<List<Integer>> graph, int selectedVertex, Set<Integer> visitedVertex, Stack<Integer> topologicalSortedValues) {
        visitedVertex.add(selectedVertex);
        for (Integer vertex : graph.get(selectedVertex)) {
            if (!visitedVertex.contains(vertex)) {
                dfs(graph, vertex, visitedVertex, topologicalSortedValues);
            }
        }
        topologicalSortedValues.push(selectedVertex);
    }

    private static int getUnvisitedVertex(List<List<Integer>> graph, Set<Integer> visitedVertex) {
        int numberOfVertex = graph.size();
        for (int i = 0; i < numberOfVertex; i++) {
            if (!visitedVertex.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private static void printTopologicalValues(Stack<Integer> topologicalSortedValues) {
        while (!topologicalSortedValues.isEmpty()) {
            System.out.print(topologicalSortedValues.pop() + " ");
        }
    }
}
