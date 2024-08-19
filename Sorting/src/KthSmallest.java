public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println("Kth smallest element is: " + kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        KthSmallest s = new KthSmallest();
        return s.quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private int quickSelect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivot = partition(arr, low, high);

        if (pivot == k) {
            return arr[pivot];
        } else if (pivot > k) {
            return quickSelect(arr, low, pivot - 1, k);
        } else {
            return quickSelect(arr, pivot + 1, high, k);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, high);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
