public class SquareRootOfNum {
    public static void main(String[] args) {
        SquareRootOfNum sr = new SquareRootOfNum();

        int n = 635;
        long sqrt = sr.floorSqrt(n);

        System.out.printf("Floor value of square root of %d is -> %d", n, sqrt);
    }

    long floorSqrt(long n) {
        if (n < 0) throw new IllegalArgumentException("Invalid Input!");

        if (n == 0 || n == 1) return n;

        long start = 1;
        long end = n;
        long ans = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (mid <= n / mid) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
