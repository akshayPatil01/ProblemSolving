import java.util.Arrays;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 10;
        System.out.println("Array: " + Arrays.toString(arr));


        SearchInRotatedArray s = new SearchInRotatedArray();
        System.out.println("Index of '" + key + "' in given array is: " + s.search(arr, key));
    }

    int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) return mid;

            if (arr[start] <= arr[mid] && arr[mid] > arr[end]) {
                if (key < arr[mid] && key >= arr[start]) end = mid;
                else start = mid + 1;
            } else {
                if (key > arr[mid] && key <= arr[end]) start = mid + 1;
                else end = mid;
            }
        }

        if (key == arr[end]) return end;

        return -1;
    }
}
