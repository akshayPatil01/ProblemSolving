import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class RemoveAllDuplicates {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5, 7));

        RemoveAllDuplicates r = new RemoveAllDuplicates();
        head = r.removeAllDuplicates(head);

        LLUtilMethods.printLL(head);
    }

    public Node<Integer> removeAllDuplicates(Node<Integer> head) {
        Node<Integer> dummy = new Node<>(-1);
        dummy.next = head;

        Node<Integer> temp = head;
        Node<Integer> prev = dummy;

        while (temp != null) {
            int curData = temp.data;
            boolean isDuplicate = false;

            while (temp.next != null && temp.next.data == curData) {
                temp = temp.next;
                isDuplicate = true;
            }

            if (isDuplicate)
                prev.next = temp.next;
            else
                prev = prev.next;

            temp = temp.next;
        }

        return dummy.next;
    }
}
