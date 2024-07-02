import Util.LLUtilMethods;
import Util.Node;

import java.util.List;

public class StringPalindromeLL {
    public static void main(String[] args) {
        Node<String> root = LLUtilMethods.createLL(List.of("b", "eeee", "b"));
        System.out.print("Original LL -->  ");
        LLUtilMethods.printLL(root);

        StringPalindromeLL s = new StringPalindromeLL();
        System.out.println("Is above string LL is a palindrome ?: " + s.compute(root));

        System.out.println("--------------------------------");

        Node<String> root2 = LLUtilMethods.createLL(List.of("b", "eeee", "b", "b"));
        System.out.print("Original LL -->  ");
        LLUtilMethods.printLL(root2);

        System.out.println("Is above string LL is a palindrome ?: " + s.compute(root2));
    }

    public boolean compute(Node<String> root) {
        Node<String> temp = root;

        StringBuilder combinedStr = new StringBuilder();
        while (temp != null) {
            combinedStr.append(temp.data);
            temp = temp.next;
        }

        String str = combinedStr.toString();
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }
}
