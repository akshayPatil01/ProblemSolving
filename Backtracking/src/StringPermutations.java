import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String S = "AABC";
        System.out.println("Available chars: " + S);

        StringPermutations s = new StringPermutations();
        System.out.println("All permutation strings: " + s.find_permutation(S));
    }

    public List<String> find_permutation(String S) {
        char[] charArray = S.toCharArray();
        boolean[] charUsed = new boolean[S.length()];
        List<String> resultList = new ArrayList<>();

        Arrays.sort(charArray);

        stringPermutation(resultList, new StringBuilder(), charUsed, charArray);

        return resultList;
    }

    private void stringPermutation(List<String> resultList, StringBuilder curString, boolean[] charUsed, char[] charArray) {
        if (curString.length() == charArray.length) {
            resultList.add(curString.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charUsed[i]) continue;

            if (i > 0 && charArray[i] == charArray[i - 1] && !charUsed[i - 1]) continue;

            charUsed[i] = true;
            curString.append(charArray[i]);
            stringPermutation(resultList, curString, charUsed, charArray);
            curString.deleteCharAt(curString.length() - 1);
            charUsed[i] = false;
        }
    }
}
