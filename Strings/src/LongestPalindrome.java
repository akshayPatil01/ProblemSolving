public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "aaaabbaa";
        System.out.println("Given String: " + str);

        System.out.println("Longest palindrome in given string: " + LongestPalindrome.longestPalindrome(str));
    }

    static String longestPalindrome(String s) {
        // code here
        if (s == null || s.isEmpty())
            return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundTheCorner(s, i, i);
            int len2 = expandAroundTheCorner(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundTheCorner(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
