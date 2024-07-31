public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[]{6,9,9};
        int n = height.length;

        long waterTrapped = TrappingRainWater.trappingWater(height, n);
        System.out.println("Water trapped: " + waterTrapped);
    }

    static long trappingWater(int[] height, int n) {
        if (height == null || n == 0) return 0;

        long trappedWater = 0;

        int left = 0, right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += (rightMax - height[right]);
                }
                right--;
            }
        }

        return trappedWater;
    }
}
