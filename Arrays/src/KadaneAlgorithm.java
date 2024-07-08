public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, -4, -3};

        KadaneAlgorithm k = new KadaneAlgorithm();
        long maxSum = k.maxSubarraySum(arr);

        System.out.println("Max Subarray sum: " + maxSum);
    }

    long maxSubarraySum(int[] arr) {
        // Your code here
        long maxSum = Long.MIN_VALUE;
        long curSum = 0;

        for (int el : arr) {
            curSum += el;
            curSum = Math.max(curSum, el);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
