import util.Edge;

import java.util.*;

public class ShortestPathToN {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;

        int[][] edges = new int[][]{{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        ShortestPathToN d = new ShortestPathToN();
        List<Integer> pathList = d.shortestPath(n, m, edges);
        System.out.println("Path from 1 to " + n + " : " + pathList);
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Edge(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }

        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);

        boolean[] visited = new boolean[n + 1];

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        pq.add(new int[]{1, 0, 0});

        while (!pq.isEmpty()) {
            int[] peek = pq.poll();

            int curNode = peek[0];
            int curCost = peek[1];
            int parent = peek[2];

            if (visited[curNode])
                continue;

            visited[curNode] = true;
            dist[curNode] = curCost;
            parents[curNode] = parent;

            for (Edge node : adjList.get(curNode)) {
                int newCost = curCost + node.cost;
                pq.add(new int[]{node.to, newCost, curNode});
            }
        }

        if (dist[n] == Integer.MAX_VALUE)
            return new ArrayList<>(List.of(-1));

        List<Integer> pathList = new ArrayList<>();
        for (int i = n; parents[i] != -1; i = parents[i]) {
            pathList.add(i);
        }
        Collections.reverse(pathList);

        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(pathList);

        return result;
    }
}

