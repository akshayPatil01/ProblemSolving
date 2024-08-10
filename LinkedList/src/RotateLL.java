import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class RotateLL {
    public static void main(String[] args) {
        int k = 4;
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.print("Given LL: ");
        LLUtilMethods.printLL(head);

        RotateLL r = new RotateLL();
        Node<Integer> newHead = r.rotate(head, k);
        System.out.print("Rotated LL: ");
        LLUtilMethods.printLL(newHead);
    }

    public Node<Integer> rotate(Node<Integer> head, int k) {
        Node<Integer> temp = head;

        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        Node<Integer> curTail = temp;

        k %= length;
        if (k == 0) return head;

        Node<Integer> newHead = head;
        temp = head;
        int i = 1;

        while (temp != null) {
            if (i == k) {
                newHead = temp.next;
                temp.next = null;
                temp = newHead;
            }

            i++;
            temp = temp.next;
        }

        curTail.next = head;

        return newHead;
    }
}
