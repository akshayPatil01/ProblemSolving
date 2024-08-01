import java.util.ArrayList;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        SpiralMatrix s = new SpiralMatrix();
        System.out.println("Traverse path in spiral form: " + s.spirallyTraverse(matrix));
    }

    public ArrayList<Integer> spirallyTraverse(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int top = 0;
        int left = 0;

        while (bottom >= top && right >= left) {
            for (int j = left; j <= right; j++)
                list.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                list.add(matrix[i][right]);
            right--;

            if (bottom >= top) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (right >= left) {
                for (int i = bottom; i >= top; i--)
                    list.add(matrix[i][left]);
                left++;
            }
        }

        return list;
    }
}
