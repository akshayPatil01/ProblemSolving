import java.util.*;

public class ArrayDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 3};
        System.out.println("Array: " + Arrays.toString(arr));

        System.out.println("Duplicate elements in array: " + ArrayDuplicates.duplicates(arr));
    }

    public static ArrayList<Integer> duplicates(int[] arr) {
        ArrayList<Integer> duplicateList = new ArrayList<>();

        Set<Integer> numSet = new HashSet<>();
        for (int el : arr) {
            if (!numSet.add(el))
                duplicateList.add(el);
        }

        if(duplicateList.isEmpty())
            duplicateList.add(-1);

        Collections.sort(duplicateList);
        return duplicateList;
    }
}
