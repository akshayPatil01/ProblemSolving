import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class RemoveLoopLL {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLLWithLoop(Arrays.asList(1, 2, 3, 4, 5), 2);

        removeLoop(head);

        System.out.print("LL without loop: ");
        LLUtilMethods.printLL(head);
    }

    public static void removeLoop(Node<Integer> head) {
        // code here
        if (head == null) return;

        Node<Integer> fastP = head.next;
        Node<Integer> slowP = head;

        while (fastP != slowP) {
            if (fastP == null || fastP.next == null) return;

            fastP = fastP.next.next;
            slowP = slowP.next;
        }

        Node<Integer> loopMemberNode = fastP;
        int loopLength = 1;

        while (loopMemberNode != fastP.next) {
            loopLength++;
            fastP = fastP.next;
        }

        slowP = head;
        fastP = head;
        while (loopLength != 1) {
            fastP = fastP.next;
            loopLength--;
        }

        while (slowP != fastP.next) {
            slowP = slowP.next;
            fastP = fastP.next;
        }

        fastP.next = null;
    }
}
