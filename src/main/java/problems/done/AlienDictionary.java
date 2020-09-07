package problems.done;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {

    }

    public static String getAlienDictionay(String words[], int size, int k) {
        List<List<Integer>> graph = getGraph(words, size);
        Stack<Integer> topologicalSortedValue = getTopologicalSortedValue(graph);
        StringBuilder sb = new StringBuilder();
        while (!topologicalSortedValue.isEmpty()) {
            sb.append('a' + topologicalSortedValue.pop());
        }
        return sb.toString();
    }


    private static List<List<Integer>> getGraph(String words[], int size) {
        List<List<Integer>> graph = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            char firstWords[] = words[i].toCharArray();
            char secondWords[] = words[i].toCharArray();
            for (int j = 0; j < Math.min(firstWords.length, secondWords.length); j++) {
                if (firstWords[j] != secondWords[j]) {
                    addEdge(graph, firstWords[j] - 'a', secondWords[j] - 'a');
                    break;
                }
            }
        }
        return graph;
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

    private static void addEdge(List<List<Integer>> graph, int i, int j) {
        graph.get(i).add(i);
    }
}
