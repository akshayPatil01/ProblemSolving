import java.util.ArrayList;
import java.util.Stack;

public class BracketNumber {
    public static void main(String[] args) {
        String str = "(aa(bdc))p(dee)";

        BracketNumber b = new BracketNumber();
        System.out.println("Bracket Number List: " + b.bracketNumbers(str));
    }

    ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> numList = new ArrayList<>();

        int curOpenNum = 0;
        Stack<Integer> s = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                curOpenNum++;
                s.push(curOpenNum);
                numList.add(curOpenNum);
            } else if (c == ')' && !s.isEmpty()) {
                int closeNum = s.pop();
                numList.add(closeNum);
            }
        }

        return numList;
    }
}
