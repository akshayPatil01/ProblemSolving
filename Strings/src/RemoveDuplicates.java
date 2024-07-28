import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "zvvo";
        System.out.println("String: " + str);

        RemoveDuplicates r = new RemoveDuplicates();
        System.out.println("String after removing all duplicates: " + r.removeDups(str));
    }

    String removeDups(String str) {
        StringBuilder sb = new StringBuilder();
        Set<Character> charSet = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (charSet.add(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
