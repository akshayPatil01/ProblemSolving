import java.util.Arrays;

public class MissingElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        System.out.println("Array: " + Arrays.toString(arr));
        MissingElement m = new MissingElement();
        System.out.println("Missing element in array is: " + m.missingNumber(arr.length + 1, arr));
    }

    int missingNumber(int n, int[] arr) {
        int sum = 0;
        for (int el : arr)
            sum += el;

        int expectedSum = n * (n + 1) / 2;

        return expectedSum - sum;
    }
}
