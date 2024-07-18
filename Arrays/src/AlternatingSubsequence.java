public class AlternatingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 10, 9, 9, 6, 7};
        AlternatingSubsequence a = new AlternatingSubsequence();

        System.out.println("Count: " + a.alternatingMaxLength(arr));
    }

    public int alternatingMaxLength(int[] arr) {
        int n = arr.length;

        int inc = 1;
        int dec = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                inc = dec + 1;
            } else if (arr[i] < arr[i - 1]) {
                dec = inc + 1;
            }
        }

        return Math.max(inc, dec);
    }
}
