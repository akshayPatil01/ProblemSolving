import java.util.Arrays;

public class LeftRotateMatrix {
    public static void main(String[] args) {
        int k = 1;
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        LeftRotateMatrix l = new LeftRotateMatrix();
        int[][] rotatedMatrix = l.rotateMatrix(k, mat);

        System.out.println("Rotated Matrix: " + Arrays.deepToString(rotatedMatrix));
    }

    public int[][] rotateMatrix(int k, int[][] mat) {
        // code here
        int n = mat[0].length;
        int m = mat.length;

        int[][] rotatedMatrix = new int[m][n];

        k %= n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol = ((n - k) + j) % n;
                rotatedMatrix[i][newCol] = mat[i][j];
            }
        }

        return rotatedMatrix;
    }
}
