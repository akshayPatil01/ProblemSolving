import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class ReverseLL {
    public static void main(String[] args) {
        Node head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("Original LL: ");
        LLUtilMethods.printLL(head);

        ReverseLL r = new ReverseLL();
        head = r.reverseList(head);

        System.out.print("Reversed LL: ");
        LLUtilMethods.printLL(head);
    }

    Node reverseList(Node head) {
        // code here
        Node next;
        Node current = head;
        Node prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }
}
