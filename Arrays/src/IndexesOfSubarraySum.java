import java.util.ArrayList;
import java.util.List;

public class IndexesOfSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int n = arr.length;
        int s = 12;

        ArrayList<Integer> sumList = subarraySum(arr, n, s);

        System.out.println("Indexes of Subarray sum: " + sumList);
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int start = 0;
        int sum = 0;

        for(int end = 0; end < n; end++) {
            sum += arr[end];

            while(sum > s && start < end) {
                sum -= arr[start];
                start++;
            }

            if(sum == s)
                return new ArrayList<Integer>(List.of(start + 1, end + 1));
        }

        return new ArrayList<Integer>(List.of(-1));
    }
}
