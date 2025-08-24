import java.util.Arrays;

public class LongestSubArrayAfterDel1 {
    public static void main(String[] args) {
        int[] input1 = new int[]{1,1,0,1};
        int[] input2 = new int[]{0,1,1,1,0,1,1};
        int[] input3 = new int[]{1,1,1};

        LongestSubArrayAfterDel1 l = new LongestSubArrayAfterDel1();
        System.out.println("Longest subarray of 1's after deleting one element: ");

        System.out.println("For input: " + Arrays.toString(input1) + " Length: " + l.getLongestSubarrayLength(input1));
        System.out.println("For input: " + Arrays.toString(input2) + " Length: " + l.getLongestSubarrayLength(input2));
        System.out.println("For input: " + Arrays.toString(input3) + " Length: " + l.getLongestSubarrayLength(input3));
    }

    private int getLongestSubarrayLength(int[] input) {
        int longestLength = 0;

        for(int i = 0; i < input.length; i++) {
            if(i > 0 && input[i-1] == 1)
                continue;

            int curLength = 0;
            int occurance = 0;
            for (int j = i; j < input.length; j++) {
                if (input[j] != 1)
                    occurance++;
                else
                    curLength++;

                if(occurance == 2)
                    break;
            }

            if(occurance == 0 && curLength == input.length)
                return input.length - 1;

            if(curLength > longestLength)
                longestLength = curLength;
        }

        return longestLength;
    }
}
