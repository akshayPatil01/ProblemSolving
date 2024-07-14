import util.GraphUtil;

import java.util.ArrayList;

public class UndirectedGraphCycle {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = GraphUtil.createDirectedAdjacencyListWithoutCost(new int[][]{{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}}, V);

        UndirectedGraphCycle u = new UndirectedGraphCycle();
        System.out.println("Is cycle present in Undirected graph ?: " + u.isCycle(V, adj));
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (dfs(adj, visited, u, -1)) return true;
            }
        }

        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int parent) {
        visited[node] = true;

        for (int curNode : adj.get(node)) {
            if (!visited[curNode]) {
                if (dfs(adj, visited, curNode, node)) return true;
            } else if (curNode != parent) return true;
        }

        return false;
    }
}
