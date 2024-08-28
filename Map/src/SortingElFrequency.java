import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortingElFrequency {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 5, 4, 6, 4, 5};

        SortingElFrequency sorting = new SortingElFrequency();
        System.out.println("Sorted list according to frequency: " + sorting.sortByFreq(arr));
    }

    public ArrayList<Integer> sortByFreq(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);


        ArrayList<Integer> list = new ArrayList<>();
        for (int num : arr)
            list.add(num);


        list.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA != freqB)
                return freqB - freqA;

            return a - b;
        });


        return list;
    }
}
