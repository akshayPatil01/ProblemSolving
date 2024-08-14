import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class Add1ToNum {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(4, 5, 6));
        Node<Integer> newHead = addOne(head);
        System.out.print("Adding 1 to 456 -> ");
        LLUtilMethods.printLL(newHead);

        Node<Integer> head2 = LLUtilMethods.createLL(Arrays.asList(9, 9, 9));
        Node<Integer> newHead2 = addOne(head2);
        System.out.print("Adding 1 to 999 -> ");
        LLUtilMethods.printLL(newHead2);
    }

    public static Node<Integer> addOne(Node<Integer> head) {
        head = reverseLL(head);

        Node<Integer> temp = head;
        int carry = 0;
        while (temp != null) {
            if (temp.data < 9) {
                temp.data += 1;
                carry = 0;
                break;
            }

            temp.data = 0;
            carry = 1;
            temp = temp.next;
        }

        head = reverseLL(head);

        if (carry == 1) {
            Node<Integer> newHead = new Node<>(1);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    private static Node<Integer> reverseLL(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
