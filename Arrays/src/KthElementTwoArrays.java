import java.util.ArrayList;

public class KthElementTwoArrays {
    public static void main(String[] args) {
        int k = 5;
        int[] arr1 = new int[]{2, 3, 6, 7, 9};
        int[] arr2 = new int[]{1, 4, 8, 10};

        KthElementTwoArrays obj = new KthElementTwoArrays();
        System.out.printf("Element at index %d is: %d", k, obj.kthElement(k, arr1, arr2));
    }

    public long kthElement(int k, int[] arr1, int[] arr2) {

        ArrayList<Integer> unionArr = new ArrayList<>();

        int i = 0, j = 0;
        int n = arr1.length;
        int m = arr2.length;

        while (j < m && i < n && unionArr.size() <= k) {
            if (arr1[i] <= arr2[j]) {
                unionArr.add(arr1[i]);
                i++;
            } else {
                unionArr.add(arr2[j]);
                j++;
            }
        }

        while (j < m && unionArr.size() <= k) {
            unionArr.add(arr2[j]);
            j++;
        }

        while (i < n && unionArr.size() <= k) {
            unionArr.add(arr1[i]);
            i++;
        }

        return unionArr.get(k - 1);
    }
}
