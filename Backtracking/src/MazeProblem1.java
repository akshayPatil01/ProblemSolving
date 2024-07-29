import java.util.ArrayList;
import java.util.Collections;

public class MazeProblem1 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}};

        MazeProblem1 m = new MazeProblem1();
        ArrayList<String> possiblePaths = m.findPath(mat);

        System.out.println("All possible paths are: " + possiblePaths);
    }

    private int n;
    private final ArrayList<String> pathList = new ArrayList<>();

    public ArrayList<String> findPath(int[][] mat) {
        n = mat.length;

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) return pathList;

        boolean[][] visited = new boolean[n][n];

        findPathHelper(mat, "", 0, 0, visited);

        Collections.sort(pathList);
        return pathList;
    }

    private final int[] X = {0, 0, 1, -1};
    private final int[] Y = {1, -1, 0, 0};
    private final String[] Dir = {"R", "L", "D", "U"};

    private void findPathHelper(int[][] mat, String curStr, int i, int j, boolean[][] visited) {
        if (i == n - 1 && j == n - 1) {
            pathList.add(curStr);
            return;
        }

        visited[i][j] = true;
        for (int r = 0; r < 4; r++) {
            int p = i + X[r];
            int q = j + Y[r];

            if (isValid(p, q) && mat[p][q] == 1 && !visited[p][q]) {
                findPathHelper(mat, curStr + Dir[r], p, q, visited);
            }
        }

        visited[i][j] = false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
