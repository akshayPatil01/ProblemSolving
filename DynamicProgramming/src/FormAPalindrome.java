public class FormAPalindrome {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println("String: " + str);

        System.out.println("Minimum number of characters to be inserted to convert it to a palindrome: " + FormAPalindrome.countMin(str));
    }

    static int countMin(String str) {
        int n = str.length();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (str.charAt(i) == str.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[0][n - 1];
    }
}
