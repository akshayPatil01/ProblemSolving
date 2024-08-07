import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class DetectLoopLL {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLLWithLoop(Arrays.asList(1, 2, 3, 4, 5), 3);
        System.out.println("Loop present ?: " + detectLoop(head));

        System.out.println();

        Node<Integer> head2 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("Original LL 2: ");
        LLUtilMethods.printLL(head2);
        System.out.println("Loop present ?: " + detectLoop(head2));
    }

    public static boolean detectLoop(Node<Integer> head) {
        Node<Integer> slowNode = head;
        Node<Integer> fastNode = head;

        while (slowNode.next != null && fastNode.next != null) {
            if (fastNode.next.next == null)
                break;

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if (slowNode == fastNode)
                return true;
        }

        return false;
    }
}
