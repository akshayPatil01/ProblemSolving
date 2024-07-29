public class Max1Row {
    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0},
                {0, 1, 1},
                {1, 0, 0}};

        Max1Row m = new Max1Row();
        System.out.println("Row index with max num of 1s: " + m.rowWithMax1s(arr));
    }

    public int rowWithMax1s(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int rowIndex = -1;
        int max1s = 0;

        for (int i = 0; i < m; i++) {
            int cur1s = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1)
                    cur1s++;
            }

            if (cur1s > max1s) {
                rowIndex = i;
                max1s = cur1s;
            }
        }

        return rowIndex;
    }
}
