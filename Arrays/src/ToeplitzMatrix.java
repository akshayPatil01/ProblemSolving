public class ToeplitzMatrix {
    public static void main(String[] args) {
        ToeplitzMatrix t = new ToeplitzMatrix();
        int[][] mat = new int[][]{{6, 7, 8},
                {4, 6, 7},
                {1, 4, 6}};
        System.out.println("Is current matrix Toeplitz ?: " + t.isToeplitz(mat));
    }

    boolean isToeplitz(int[][] mat) {
        // Your code here
        int m = mat.length;
        int n = mat[0].length;

        if (n == 1 || m == 1)
            return true;

        int numOfDiagonals = m == n ? m + n - 1 : m + n;
        for (int i = 0; i < numOfDiagonals; i++) {
            int row;
            int column;

            if (i < m) {
                row = i;
                column = 0;
            } else {
                row = 0;
                column = i - m + 1;
            }

            while (row < (m - 1) && column < (n - 1)) {
                if (mat[row][column] != mat[row + 1][column + 1])
                    return false;

                row++;
                column++;
            }
        }

        return true;
    }
}
