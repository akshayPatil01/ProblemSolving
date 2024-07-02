import Util.DLLNode;
import Util.LLUtilMethods;

import java.util.Arrays;

public class DeleteNodeDLL {
    public static void main(String[] args) {
        DLLNode<Integer> head = LLUtilMethods.createDLL(Arrays.asList(1, 2, 3, 4, 5));

        System.out.print("Original DLL  -->  ");
        LLUtilMethods.printDLL(head);

        int position = 3;
        head = deleteNode(head, position);

        System.out.print("After deleting node at position " + position + "  -->  ");
        LLUtilMethods.printDLL(head);
    }

    public static DLLNode<Integer> deleteNode(DLLNode<Integer> head, int x) {
        DLLNode<Integer> temp = head;

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


