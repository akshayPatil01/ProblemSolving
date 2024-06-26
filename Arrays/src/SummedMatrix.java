public class SummedMatrix {
    public static void main(String[] args) {
        int n = 4;
        int q = 7;

        System.out.println("Number of cells having value " + n + ": " + sumMatrix(n, q));
    }

    public static long sumMatrix(long n, long q) {
        // code here
        if (q > n * 2 || q < 2)
            return 0;

        if (q <= 1 + n)
            return q - 1;

        return 2 * n - q + 1;
    }
}
