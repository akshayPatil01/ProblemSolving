import java.util.HashSet;
import java.util.Set;

public class KPangrams {
    public static void main(String[] args) {
        String str = "a b c d e f g h i j k l m";
        int k = 20;

        KPangrams p = new KPangrams();
        System.out.println("Could given string change into a pangram after at most k operations ?: " + p.kPangram(str, k));
    }

    boolean kPangram(String str, int k) {
        Set<Character> charSet = new HashSet<>();

        str = str.toLowerCase();
        int alphabeticCharCount = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                charSet.add(c);
                alphabeticCharCount++;
            }
        }

        return 26 - charSet.size() <= k && alphabeticCharCount >= 26;
    }
}
