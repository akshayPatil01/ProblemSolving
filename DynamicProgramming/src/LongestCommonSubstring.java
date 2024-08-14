public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcabcbb";
        String str2 = "bbbbbb";

        LongestCommonSubstring l = new LongestCommonSubstring();
        System.out.println("Longest common substring length: " + l.longestCommonSubstr(str1, str2));
    }

    public int longestCommonSubstr(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];
        int maxLength = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
}
