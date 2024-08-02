public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};

        CelebrityProblem c = new CelebrityProblem();
        System.out.println("Index of celebrity is: " + c.celebrity(mat));
    }

    public int celebrity(int[][] mat) {
        int n = mat.length;

        if (n == 1) return 0;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (knows(mat, i, j)) {
                i++;
            } else {
                j--;
            }
        }

        for (int k = 0; k < n; k++) {
            if (k != i && (!knows(mat, k, i) || knows(mat, i, k))) return -1;
        }

        return i;
    }

    private boolean knows(int[][] mat, int i, int j) {
        return mat[i][j] == 1;
    }
}
