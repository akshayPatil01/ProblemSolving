public class MaximizeCuts {
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 5;
        int z = 2;

        MaximizeCuts m = new MaximizeCuts();
        System.out.println("Maximum number of cuts: " + m.maximizeCuts(n, x, y, z));
    }

    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        int[] len = new int[]{x, y, z};

        for (int k = 0; k < 3; k++) {
            int i = len[k];
            for (int j = i; j <= n; j++) {
                if (j - i != 0 && dp[j - i] == 0)
                    continue;

                dp[j] = Math.max(dp[j], dp[j - i] + 1);
            }
        }

        return dp[n];
    }
}
