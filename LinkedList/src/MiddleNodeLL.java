import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class MiddleNodeLL {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("LL: ");
        LLUtilMethods.printLL(head);

        MiddleNodeLL m = new MiddleNodeLL();
        int middleNode = m.getMiddle(head);
        System.out.println("Middle node of LL is: " + middleNode);
    }

    int getMiddle(Node<Integer> head) {
        // Your code here.
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null)
            slow = slow.next;

        return slow.data;
    }
}
