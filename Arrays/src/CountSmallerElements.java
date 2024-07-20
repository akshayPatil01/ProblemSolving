import java.util.Arrays;

public class CountSmallerElements {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 1, 2, 3, 0, 11, 4};

        CountSmallerElements c = new CountSmallerElements();
        int[] res = c.constructLowerArray(arr);
        System.out.println("Smaller element on right side count array: " + Arrays.toString(res));
    }

    int[] constructLowerArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(nums, indices, result, 0, n - 1);

        return result;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] result, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, result, left, mid);
        mergeSort(nums, indices, result, mid + 1, right);

        merge(nums, indices, result, left, mid, right);
    }

    private static void merge(int[] nums, int[] indices, int[] result, int left, int mid, int right) {
        int[] leftPart = Arrays.copyOfRange(indices, left, mid + 1);
        int[] rightPart = Arrays.copyOfRange(indices, mid + 1, right + 1);

        int i = 0, j = 0;
        int k = left;
        int rightCount = 0;

        while (i < leftPart.length && j < rightPart.length) {
            if (nums[leftPart[i]] <= nums[rightPart[j]]) {
                result[leftPart[i]] += rightCount;
                indices[k++] = leftPart[i++];
            } else {
                rightCount++;
                indices[k++] = rightPart[j++];
            }
        }

        while (i < leftPart.length) {
            result[leftPart[i]] += rightCount;
            indices[k++] = leftPart[i++];
        }

        while (j < rightPart.length) {
            indices[k++] = rightPart[j++];
        }
    }
}
