import Util.LLUtilMethods;
import Util.Node;

public class RemoveLoopLL {
    public static void main(String[] args) {
        Node head = LLUtilMethods.createLLWithLoop();

        removeLoop(head);

        System.out.print("LL without loop: ");
        LLUtilMethods.printLL(head);
    }

    public static void removeLoop(Node head) {
        // code here
        if (head == null) return;

        Node fastP = head.next;
        Node slowP = head;

        while (fastP != slowP) {
            if (fastP == null || fastP.next == null) return;

            fastP = fastP.next.next;
            slowP = slowP.next;
        }

        Node loopMemberNode = fastP;
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
