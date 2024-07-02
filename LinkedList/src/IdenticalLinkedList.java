import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;
import java.util.Objects;

public class IdenticalLinkedList {
    public static void main(String[] args) {
        IdenticalLinkedList i = new IdenticalLinkedList();

        Node<Integer> head1 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("LL 1: ");
        LLUtilMethods.printLL(head1);

        Node<Integer> head2 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("LL 2: ");
        LLUtilMethods.printLL(head2);

        System.out.println("Are LinkedLists Identical ?: " + i.areIdentical(head1, head2));

        System.out.println("------");

        Node<Integer> head3 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 6));
        System.out.print("LL 3: ");
        LLUtilMethods.printLL(head3);

        Node<Integer> head4 = LLUtilMethods.createLL(Arrays.asList(2, 3, 4, 5, 1));
        System.out.print("LL 4: ");
        LLUtilMethods.printLL(head4);

        System.out.println("Are LinkedLists Identical ?: " + i.areIdentical(head3, head4));
    }

    public boolean areIdentical(Node<Integer> head1, Node<Integer> head2) {
        // write your code here
        while (head1 != null && head2 != null) {
            if (!Objects.equals(head1.data, head2.data))
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }
}
