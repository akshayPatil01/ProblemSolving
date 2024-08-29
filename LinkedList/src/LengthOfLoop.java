import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class LengthOfLoop {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLLWithLoop(Arrays.asList(25, 14, 19, 33, 10, 21, 39, 90, 58, 45), 7);

        LengthOfLoop l = new LengthOfLoop();
        System.out.println("Length of loop is: " + l.lengthOfLoop(head));
    }

    public int lengthOfLoop(Node<Integer> head) {
        if (head == null)
            return 0;

        Node<Integer> slow = head;
        Node<Integer> fast = head.next;

        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) {
                return 0;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        int length = 1;
        while (fast.next != slow) {
            length++;
            fast = fast.next;
        }

        return length;
    }
}
