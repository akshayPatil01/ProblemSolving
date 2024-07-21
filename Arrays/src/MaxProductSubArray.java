import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProductSubArray {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-1, -1, -2, 4, 3));

        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        System.out.println("Max Product of sub array: " + maxProductSubArray.findMaxProduct(arr));
    }

    public long findMaxProduct(List<Integer> arr) {
        int n = arr.size();
        final long MOD = (long) (7 + 10e8);

        long maxProduct = 1;
        long negCount = 0;
        long lowestNeg = Long.MIN_VALUE;
        long zeroCount = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
                continue;
            } else if (num < 0) {
                negCount++;
                lowestNeg = Math.max(lowestNeg, num);
            }

            maxProduct = (maxProduct * num) % MOD;
        }

        if (zeroCount == n || (negCount == 1 && negCount + zeroCount == n)) return 0;

        if (negCount % 2 == 1) {
            maxProduct /= lowestNeg;
        }

        return maxProduct;
    }
}
