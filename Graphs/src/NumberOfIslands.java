public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };

        NumberOfIslands n = new NumberOfIslands();
        System.out.println("Number of Islands in grid: " + n.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;

        int numOfIslands = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited, n, m);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private final int[] ROW_VECTOR = new int[]{0, 0, -1, -1, -1, 1, 1, 1};
    private final int[] COLUMN_VECTOR = new int[]{-1, 1, 0, -1, 1, 0, -1, 1};

    private void dfs(int i, int j, char[][] grid, boolean[][] visited, int n, int m) {
        visited[i][j] = true;

        for (int k = 0; k < ROW_VECTOR.length; k++) {
            int p = i + ROW_VECTOR[k];
            int q = j + COLUMN_VECTOR[k];

            if (isValid(p, q, n, m) && !visited[p][q] && grid[p][q] == '1') {
                dfs(p, q, grid, visited, n, m);
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
