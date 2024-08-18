public class EqualSumSubArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 5};

        EqualSumSubArrays e = new EqualSumSubArrays();
        System.out.println("Can we Split an array into equal sub arrays: " + e.canSplit(arr));
    }

    public boolean canSplit(int[] arr) {
        int sum = 0;

        for (int j : arr)
            sum += j;

        int curSum = 0;

        for (int j : arr) {
            curSum += j;
            sum -= j;

            if (curSum == sum) return true;
            else if (curSum > sum) return false;
        }

        return false;
    }
}
