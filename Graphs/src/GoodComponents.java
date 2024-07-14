import util.GraphUtil;

import java.util.ArrayList;

public class GoodComponents {
    public static void main(String[] args) {
        int V = 7;
        int[][] edges = {{1, 2}, {7, 2}, {3, 5}, {3, 4}, {4, 5}};

        System.out.println("Number of Good components in graph: " + GoodComponents.findNumberOfGoodComponent(V, edges));
    }

    public static int findNumberOfGoodComponent(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = GraphUtil.createUndirectedAdjacencyListWithoutCost(edges, V + 1);

        boolean[] visited = new boolean[V + 1];

        int goodComponents = 0;

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                int[] vertices = {0};
                int[] edgeCount = {0};

                dfs(vertices, edgeCount, adj, visited, i);

                edgeCount[0] /= 2;

                if (edgeCount[0] == (vertices[0] * (vertices[0] - 1)) / 2)
                    goodComponents++;
            }
        }

        return goodComponents;
    }

    private static void dfs(int[] vertices, int[] edgeCount, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        vertices[0]++;

        edgeCount[0] += adj.get(node).size();
        for (int curNode : adj.get(node)) {
            if (!visited[curNode]) {
                dfs(vertices, edgeCount, adj, visited, curNode);
            }
        }
    }
}
