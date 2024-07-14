package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphUtil {
    public static ArrayList<ArrayList<ArrayList<Integer>>> createAdjacencyList(int[][][] nodes) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int[][] node : nodes) {
            ArrayList<ArrayList<Integer>> curNodeEdges = new ArrayList<>();
            for (int[] edge : node) {
                curNodeEdges.add(new ArrayList<>(Arrays.asList(edge[0], edge[1])));
            }

            adj.add(curNodeEdges);
        }

        return adj;
    }

    public static ArrayList<ArrayList<ArrayList<Integer>>> createUndirectedAdjacencyListFromEdges(int[][] edges, int V) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new ArrayList<>(Arrays.asList(edge[1], edge[2])));
            adjList.get(edge[1]).add(new ArrayList<>(Arrays.asList(edge[0], edge[2])));
        }

        return adjList;
    }

    public static ArrayList<ArrayList<Integer>> createDirectedAdjacencyListWithoutCost(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            List<Integer> list = Arrays.stream(edges[i]).boxed().toList();
            adjList.add(new ArrayList<>(list));
        }

        return adjList;
    }

    public static ArrayList<ArrayList<Integer>> createUndirectedAdjacencyListWithoutCost(int[][] edges, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
