public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 4;

        CoinChange c = new CoinChange();
        System.out.printf("Number of ways we can make %d sum: %d", sum, c.count(coins, sum));
    }

    public long count(int[] coins, int sum) {
        long[] dp = new long[sum + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[sum];
    }

    /* Recursive Approach  */

//    public long count(int[] coins, int N, int sum) {
//        if (sum == 0) return 1;
//
//        long coinCount = 0;
//
//        int[] updatedCoins = new int[N - 1];
//        System.arraycopy(coins, 1, updatedCoins, 0, N - 1);
//
//        if (N > 1) coinCount += count(updatedCoins, N - 1, sum);
//
//        if (sum >= coins[0]) coinCount += count(coins, N, sum - coins[0]);
//
//        return coinCount;
//    }
}
