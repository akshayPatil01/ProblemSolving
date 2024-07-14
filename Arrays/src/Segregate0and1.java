import java.util.Arrays;

public class Segregate0and1 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 0};
        System.out.println("0 1 Array: " + Arrays.toString(arr));

        Segregate0and1 s = new Segregate0and1();
        s.segregate0and1(arr);

        System.out.println("Array after segregation: " + Arrays.toString(arr));
    }

    public void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (left < right && arr[right] == 1) right--;

            while (left < right && arr[left] == 0) left++;

            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                right--;
                left++;
            }
        }
    }
}
