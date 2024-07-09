public class CommonPrefix {
    public static void main(String[] args) {
        int n = 4;
        String[] arr = {"geeksforgeeks", "geeks", "geek", "geezer"};

        CommonPrefix c = new CommonPrefix();
        System.out.println("Longest common prefix: " + c.longestCommonPrefix(n, arr));
    }

    String longestCommonPrefix(int n, String[] arr) {
        if (arr == null || n == 0)
            return "-1";

        String commonPrefix = arr[0];

        for (int i = 1; i < n; i++) {
            while (!arr[i].startsWith(commonPrefix)) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
                if (commonPrefix.isEmpty())
                    return "-1";
            }
        }

        return commonPrefix;
    }
}
