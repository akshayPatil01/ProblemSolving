public class LargestSquareMatrix {
    public static void main(String[] args) {
        int n = 3;
        int m = 10;
        int[][] mat = new int[][]{
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
        };


        System.out.println("Length of Largest square formed in a matrix: " + LargestSquareMatrix.maxSquare(n, m, mat));
    }

    static int maxSquare(int n, int m, int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0)
            return 0;

        int maxSide = 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    }

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide;
    }

}
