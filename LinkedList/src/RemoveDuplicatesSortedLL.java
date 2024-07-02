import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;
import java.util.Objects;

public class RemoveDuplicatesSortedLL {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6));
        System.out.print("Original LL:   ");
        LLUtilMethods.printLL(head);

        System.out.println("---------------");

        RemoveDuplicatesSortedLL r = new RemoveDuplicatesSortedLL();
        head = r.removeDuplicates(head);
        System.out.print("LL after removing duplicates: ");
        LLUtilMethods.printLL(head);
    }

    Node<Integer> removeDuplicates(Node<Integer> head) {
        // Your code here
        if (head == null) return null;

        Node<Integer> current = head;
        Node<Integer> next = head.next;

        while (next != null) {
            if (Objects.equals(current.data, next.data)) {
                next = next.next;
                current.next = next;
            } else {
                current = next;
                next = next.next;
            }
        }

        return head;
    }
}
