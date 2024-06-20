package Maths.src;

public class IntegralPointsInsideTriangle {
    public static void main(String[] args) {
        long[] p = {0, 0};
        long[] q = {0, 5};
        long[] r = {5, 0};

        System.out.println("Count of integral points inside triangle: " + InternalCount(p, q, r));
    }

    private static long InternalCount(long[] p, long[] q, long[] r) {
        // code here
        long BoundaryPoints = getBoundaryCount(p, q) +
                getBoundaryCount(p, r) +
                getBoundaryCount(q, r) + 3;

        long doubleArea = Math.abs(p[0] * (q[1] - r[1]) +
                q[0] * (r[1] - p[1]) +
                r[0] * (p[1] - q[1]));

        return (doubleArea - BoundaryPoints + 2) / 2;
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long getBoundaryCount(long[] p, long[] q) {
        if (p[0] == q[0])
            return Math.abs(p[1] - q[1]) - 1;

        if (p[1] == q[1])
            return Math.abs(p[0] - q[0]) - 1;

        return gcd(Math.abs(p[0] - q[0]),
                Math.abs(p[1] - q[1])) - 1;
    }
}
