public class PalindromePattern {
    public static void main(String[] args) {
        PalindromePattern p = new PalindromePattern();
        int[][] arr = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 0}
        };

        System.out.println(p.pattern(arr));
    }

    public String pattern(int[][] arr) {
        // Code here
        int m = arr.length;
        int n = arr[0].length;

        // for rows
        for (int i = 0; i < m; i++) {
            StringBuilder str = new StringBuilder();

            for (int j = 0; j < n; j++) {
                str.append(arr[i][j]);
            }

            if (isPalindrome(str))
                return i + " R";
        }

        // for columns
        for (int j = 0; j < n; j++) {
            StringBuilder str = new StringBuilder();

            for (int[] nums : arr) {
                str.append(nums[j]);
            }

            if (isPalindrome(str))
                return j + " C";
        }

        return "-1";
    }

    private boolean isPalindrome(StringBuilder str) {
        StringBuilder copyStr = new StringBuilder(str);
        return copyStr.reverse().compareTo(str) == 0;
    }
}
