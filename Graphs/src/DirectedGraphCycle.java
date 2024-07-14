import util.GraphUtil;

import java.util.ArrayList;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = GraphUtil.createDirectedAdjacencyListWithoutCost(new int[][]{{1}, {2}, {3}, {3}}, V);

        DirectedGraphCycle u = new DirectedGraphCycle();
        System.out.println("Is cycle present in Directed graph ?: " + u.isCycle(V, adj));
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int u = 0; u < V; u++) {
            if (!visited[u]) {
                if (dfs(adj, visited, recStack, u)) return true;
            }
        }

        return false;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack, int node) {
        if (recStack[node]) return true;

        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int curNode : adj.get(node)) {
            if (dfs(adj, visited, recStack, curNode)) return true;
        }

        recStack[node] = false;

        return false;
    }
}
