import java.util.Arrays;

public class ClosestTripletSum {
    public static void main(String[] args) {
        int[] arr = new int[]{89, 7, 15, -73, -45, -52, -43, -7, -92, -13, 20, -10};
        int target = 26;

        System.out.println("Given array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        int closestSum = ClosestTripletSum.threeSumClosest(arr, target);
        System.out.println("Closest sum to given target is: " + closestSum);
    }

    public static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);

        int n = array.length;
        int closestSum = Integer.MAX_VALUE;
        int closestDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int curSum = array[i] + array[left] + array[right];
                int curDiff = Math.abs(curSum - target);

                if (curSum == target)
                    return curSum;

                if (curDiff < closestDiff || (curDiff == closestDiff && curSum > closestSum)) {
                    closestDiff = curDiff;
                    closestSum = curSum;
                }

                if (curSum < target) {
                    left++;
                } else
                    right--;

            }
        }

        return closestSum;
    }
}
