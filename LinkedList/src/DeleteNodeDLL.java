import Util.DLLNode;
import Util.LLUtilMethods;

import java.util.Arrays;

public class DeleteNodeDLL {
    public static void main(String[] args) {
        DLLNode head = LLUtilMethods.createDLL(Arrays.asList(1, 2, 3, 4, 5));

        System.out.print("Original DLL  -->  ");
        LLUtilMethods.printDLList(head);

        int position = 3;
        head = deleteNode(head, position);

        System.out.print("After deleting node at position " + position + "  -->  ");
        LLUtilMethods.printDLList(head);
    }

    public static DLLNode deleteNode(DLLNode head, int x) {
        DLLNode temp = head;

        while (x > 1) {
            temp = temp.next;
            if (temp == null)        // if node not present
                return head;
            x--;
        }

        if (temp.prev != null)
            temp.prev.next = temp.next;
        else {                      // if node to be deleted is HEAD
            if (temp.next != null)   // Check if it is Single Util.Node list
                temp.next.prev = null;

            return temp.next;
        }

        if (temp.next != null)       // Check if the node to be deleted is the last node
            temp.next.prev = temp.prev;

        return head;
    }
}


