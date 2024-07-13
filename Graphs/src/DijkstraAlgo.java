import util.GraphUtil;

import java.util.*;

public class DijkstraAlgo {
    public static void main(String[] args) {
        int V = 3;
        int S = 2;

        int[][][] graph = new int[][][]{{{1, 1}, {2, 6}}, {{2, 3}, {0, 1}}, {{1, 3}, {0, 6}}};

        ArrayList<ArrayList<ArrayList<Integer>>> adjList = GraphUtil.createAdjacencyList(graph);

        int[] dist = DijkstraAlgo.dijkstra(V, adjList, S);
        System.out.println("Shortest distance of all nodes from node " + S + " : " + Arrays.toString(dist));
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[V];

        pq.offer(new int[]{S, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int node = cur[0];
            int cost = cur[1];

            if (visited.contains(node)) continue;

            visited.add(node);
            distance[node] = cost;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int newCost = cost + edge.get(1);
                pq.offer(new int[]{edge.get(0), newCost});
            }
        }

        return distance;
    }
}
