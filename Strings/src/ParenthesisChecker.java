import java.util.Stack;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String str = "([]";
        System.out.println(isPar(str));
    }

    private static boolean isPar(String x) {
        Stack<Character> parStack = new Stack<>();

        for (char par : x.toCharArray()) {
            if (par == '{' || par == '(' || par == '[')
                parStack.push(par);
            else {
                if (parStack.empty())
                    return false;

                char peekPar = parStack.pop();
                switch (peekPar) {
                    case '{':
                        if (par != '}')
                            return false;
                        break;
                    case '(':
                        if (par != ')')
                            return false;
                        break;
                    case '[':
                        if (par != ']')
                            return false;
                        break;
                    default:
                        break;
                }
            }
        }

        return parStack.isEmpty();
    }
}
