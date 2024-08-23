import java.util.ArrayList;

public class FirstAndLastOccurrences {
    public static void main(String[] args) {
        FirstAndLastOccurrences f = new FirstAndLastOccurrences();

        int[] arr = new int[]{6, 6, 6, 6, 7, 7, 7, 8};
        int n = arr.length;
        int x = 8;

        ArrayList<Integer> indexList = f.find(arr, n, x);
        System.out.println("First and Last occurrences of " + x + ": " + indexList);
    }

    ArrayList<Integer> find(int[] arr, int n, int x) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == arr[mid]) {
                int temp = mid;
                while (temp > 0 && arr[temp - 1] == x) temp--;

                indexList.add(temp);

                temp = mid;
                while (temp < n - 1 && arr[temp + 1] == x) temp++;

                indexList.add(temp);

                return indexList;
            }

            if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        indexList.add(-1);
        indexList.add(-1);

        return indexList;
    }
}
