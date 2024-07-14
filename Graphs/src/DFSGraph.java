import util.GraphUtil;

import java.util.ArrayList;

public class DFSGraph {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        ArrayList<ArrayList<Integer>> adj = GraphUtil.createDirectedAdjacencyListWithoutCost(edges, V);

        DFSGraph b = new DFSGraph();
        System.out.println("DFS of graph: " + b.dfsOfGraph(V, adj));
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfsList = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfs(adj, visited, dfsList, 0);
        return dfsList;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsList, int node) {
        visited[node] = true;
        dfsList.add(node);

        ArrayList<Integer> connectedNodes = adj.get(node);
        for (int curNode : connectedNodes) {
            if (!visited[curNode]) {
                dfs(adj, visited, dfsList, curNode);
            }
        }
    }
}
