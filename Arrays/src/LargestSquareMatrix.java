public class LargestSquareMatrix {
    public static void main(String[] args) {
        int n = 3;
        int m = 10;
        int[][] mat = new int[][]{
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0, 1, 1, 1, 1, 1},
        };


        System.out.println("Length of Largest square formed in a matrix: " + LargestSquareMatrix.maxSquare(n, m, mat));
    }

    static int maxSquare(int n, int m, int[][] mat) {
        // code here
        int sideLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 1)
                    continue;

                int curLength = findMaxSideLength(i, j, n, m, mat);
                if (curLength > sideLength)
                    sideLength = curLength;

                if (sideLength == n || sideLength == m)
                    return sideLength;
            }
        }

        return sideLength;
    }

    private static int findMaxSideLength(int i, int j, int n, int m, int[][] mat) {
        int p = i;
        int q = j;

        while (q < m && q - j < n) {
            if (mat[p][q] != 1)
                break;
            q++;
        }

        int sideLength = q - j;

        p++;

        int extractedLength = 1;

        while (p < i + sideLength && p < n) {
            for (int c = j; c < j + sideLength; c++) {
                if (mat[p][c] != 1) {
                    sideLength = c - j;
                    break;
                }
            }

            int curLength = Math.min((p - i + 1), sideLength);
            extractedLength = Math.max(extractedLength, curLength);
            p++;
        }

        return extractedLength;
    }
}
