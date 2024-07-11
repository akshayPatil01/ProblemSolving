import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumConnectedGroup {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0},
                {1, 0, 1},
                {1, 0, 0}
        };

        MaximumConnectedGroup group = new MaximumConnectedGroup();
        System.out.println("Size of maximum connected group: " + group.maxConnection(grid));
    }

    public int maxConnection(int[][] grid) {
        int n = grid.length;

        int maxConnections = 0;
        int groupId = 2;
        Map<Integer, Integer> groupMap = new HashMap<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int connections = dfs(grid, n, i, j, visited, groupId);
                    groupMap.put(groupId, connections);

                    maxConnections = Math.max(maxConnections, connections);
                    groupId++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> groupSet = new HashSet<>();
                    int curGroupSize = 1;

                    if (isValid(i + 1, j, n, grid)) groupSet.add(grid[i + 1][j]);
                    if (isValid(i, j + 1, n, grid)) groupSet.add(grid[i][j + 1]);
                    if (isValid(i, j - 1, n, grid)) groupSet.add(grid[i][j - 1]);
                    if (isValid(i - 1, j, n, grid)) groupSet.add(grid[i - 1][j]);

                    for (int id : groupSet) {
                        curGroupSize += groupMap.get(id);
                    }

                    maxConnections = Math.max(maxConnections, curGroupSize);
                }
            }
        }

        return maxConnections;
    }

    private int dfs(int[][] grid, int n, int i, int j, boolean[][] visited, int groupId) {
        visited[i][j] = true;
        grid[i][j] = groupId;
        int count = 1;

        if (isValid(i + 1, j, n, grid, visited)) count += dfs(grid, n, i + 1, j, visited, groupId);

        if (isValid(i, j + 1, n, grid, visited)) count += dfs(grid, n, i, j + 1, visited, groupId);

        if (isValid(i, j - 1, n, grid, visited)) count += dfs(grid, n, i, j - 1, visited, groupId);

        if (isValid(i - 1, j, n, grid, visited)) count += dfs(grid, n, i - 1, j, visited, groupId);

        return count;
    }

    private boolean isValid(int i, int j, int n, int[][] grid, boolean[][] visited) {
        return isValid(i, j, n, grid) && !visited[i][j];
    }

    private boolean isValid(int i, int j, int n, int[][] grid) {
        return i >= 0 && j >= 0 && i < n && j < n && grid[i][j] >= 1;
    }
}
