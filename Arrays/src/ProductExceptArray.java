import java.util.Arrays;

public class ProductExceptArray {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 3, 5, 6, 2};
        long[] result = ProductExceptArray.productExceptSelf(nums);

        System.out.println(Arrays.toString(result));
    }

    public static long[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        long rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
