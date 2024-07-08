public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        int minJumps = MinimumJumps.minJumps(arr, arr.length);
        System.out.println("Minimum Jumps required: " + minJumps);
    }

    public static int minJumps(int[] arr, int n) {
        if (n <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

        int jumpCount = 1;
        int maxReach = arr[0];
        int remainingSteps = arr[0];

        for (int i = 1; i < n; i++) {
            if (i == n - 1)
                return jumpCount;

            remainingSteps--;

            if (i + arr[i] > maxReach) {
                maxReach = i + arr[i];
            }

            if (remainingSteps == 0) {
                if (maxReach <= i)
                    return -1;

                jumpCount++;
                remainingSteps = maxReach - i;
            }
        }

        return jumpCount;
    }
}
