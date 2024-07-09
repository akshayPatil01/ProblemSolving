public class MinCostIdentical {
    public static void main(String[] args) {
        String x = "abcd";
        String y = "acdb";
        int costX = 10;
        int costY = 20;

        System.out.println("X: " + x + "   Y: " + y);

        MinCostIdentical m = new MinCostIdentical();
        System.out.println("Minimum cost to make given strings identical: " + m.findMinCost(x, y, costX, costY));

    }

    public int findMinCost(String x, String y, int costX, int costY) {
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int lcs = dp[m][n];
        return (m - lcs) * costX + (n - lcs) * costY;
    }
}
