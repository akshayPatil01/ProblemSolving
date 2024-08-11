public class MedianOfTwoArr {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 4, 6, 10};
        int[] arr2 = new int[]{4, 5, 6, 9, 12};

        MedianOfTwoArr m = new MedianOfTwoArr();
        System.out.println("Sum of middle elements: " + m.sumOfMiddleElements(arr1, arr2));
    }

    public int sumOfMiddleElements(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int mid;
        if ((m + n) % 2 == 0) mid = (m + n) / 2;
        else mid = (m + n + 1) / 2;

        int sum = 0;

        int i = 0;
        int j = 0;
        for (int k = 0; k < n + m; k++) {
            int cur;
            if (arr1[i] <= arr2[j]) {
                cur = arr1[i];
                i++;
            } else {
                cur = arr2[j];
                j++;
            }

            if (k == mid - 1) {
                sum += cur;
            } else if (k == mid) {
                sum += cur;
                return sum;
            }
        }

        return 0;
    }
}
