import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class KthNodeLL {
    public static void main(String[] args) {
        Node head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5));
        System.out.print("LL: ");
        LLUtilMethods.printLL(head);

        KthNodeLL kthNodeLL = new KthNodeLL();

        int k = 4;
        int kth = kthNodeLL.getNthFromLast(head, k);
        System.out.println(k + "th node from last is: " + kth);
    }

    int getNthFromLast(Node head, int n) {
        // Your code here
        int temp = n;
        Node tempNode = head;

        while (temp != 0) {
            if (tempNode == null)
                return -1;

            tempNode = tempNode.next;
            temp--;
        }

        Node nthNode = head;
        while (tempNode != null) {
            nthNode = nthNode.next;
            tempNode = tempNode.next;
        }

        assert nthNode != null;
        return nthNode.data;
    }
}
