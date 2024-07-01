import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class RemoveDuplicatesSortedLL {
    public static void main(String[] args) {
        Node head = LLUtilMethods.createLL(Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6));
        System.out.print("Original LL:   ");
        LLUtilMethods.printLL(head);

        System.out.println("---------------");

        RemoveDuplicatesSortedLL r = new RemoveDuplicatesSortedLL();
        head = r.removeDuplicates(head);
        System.out.print("LL after removing duplicates: ");
        LLUtilMethods.printLL(head);
    }

    Node removeDuplicates(Node head) {
        // Your code here
        if (head == null) return null;

        Node current = head;
        Node next = head.next;

        while (next != null) {
            if (current.data == next.data) {
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
