public class EditDistance {
    public static void main(String[] args) {
        String str1 = "ecfbefdcfca";
        String str2 = "badfcbebbf";

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        EditDistance edit = new EditDistance();
        System.out.println("Min number of operations required to match the strings: " + edit.editDistance(str1, str2));
    }

    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
