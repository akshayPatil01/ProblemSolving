public class CoverageBinaryMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 0}, {0, 1, 1}, {0, 0, 0}};

        CoverageBinaryMatrix c = new CoverageBinaryMatrix();
        System.out.println("Coverage of all Zeros in a Binary Matrix: " + c.findCoverage(matrix));
    }

    public int findCoverage(int[][] matrix) {
        // code here
        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    count += coverageCount(i, j, m, n, matrix);
            }
        }

        return count;
    }

    private int coverageCount(int i, int j, int m, int n, int[][] matrix) {
        int count = 0;

        if (isValid(i - 1, j, m, n) && matrix[i - 1][j] == 1)
            count++;

        if (isValid(i, j + 1, m, n) && matrix[i][j + 1] == 1)
            count++;

        if (isValid(i + 1, j, m, n) && matrix[i + 1][j] == 1)
            count++;

        if (isValid(i, j - 1, m, n) && matrix[i][j - 1] == 1)
            count++;

        return count;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}
