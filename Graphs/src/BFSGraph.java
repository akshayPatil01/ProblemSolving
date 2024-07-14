import util.GraphUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{1, 2, 3}, {}, {4}, {}, {}};
        ArrayList<ArrayList<Integer>> adj = GraphUtil.createDirectedAdjacencyListWithoutCost(edges, V);

        BFSGraph b = new BFSGraph();
        System.out.println("BFS of graph: " + b.bfsOfGraph(V, adj));
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();

        q.add(0);
        while (!q.isEmpty()) {
            int n = q.poll();

            if (visited[n])
                continue;

            visited[n] = true;
            bfs.add(n);

            for (int v : adj.get(n)) {
                if (!visited[v]) {
                    q.add(v);
                }
            }
        }

        return bfs;
    }
}
