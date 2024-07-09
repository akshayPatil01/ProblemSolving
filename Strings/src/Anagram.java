import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String a = "geeksforgeeks";
        String b = "forgeeksgeeks";

        System.out.println("A: " + a + "   B: " + b);
        System.out.println("Are given strings anagram ?: " + Anagram.isAnagram(a, b));
    }

    public static boolean isAnagram(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();

        if (lengthA != lengthB)
            return false;

        Map<Character, Integer> charFreqMap = new HashMap<>();

        int freq;
        for (int i = 0; i < lengthA; i++) {
            freq = charFreqMap.getOrDefault(a.charAt(i), 0);
            charFreqMap.put(a.charAt(i), freq + 1);

            freq = charFreqMap.getOrDefault(b.charAt(i), 0);
            charFreqMap.put(b.charAt(i), freq - 1);
        }

        return charFreqMap.values().stream().noneMatch(f -> f != 0);
    }
}
