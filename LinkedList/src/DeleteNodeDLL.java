public class DeleteNodeDLL {
    DLLNode head; // head of the list

    public static void main(String[] args) {
        DeleteNodeDLL dll = new DeleteNodeDLL();

        dll.append(1);
        dll.append(3);
        dll.append(4);
        dll.append(5);

        System.out.print("Original DLL  -->  ");
        printList(dll.head);

        int position = 3;
        dll.head = dll.deleteNode(dll.head, position);

        System.out.print("After deleting node at position " + position + "  -->  ");
        printList(dll.head);
    }

    public void append(int new_data) {
        DLLNode new_node = new DLLNode(new_data);
        DLLNode last = head;

        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;
    }

    public DLLNode deleteNode(DLLNode head, int x) {
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
            if (temp.next != null)   // Check if it is Single Node list
                temp.next.prev = null;

            return temp.next;
        }

        if (temp.next != null)       // Check if the node to be deleted is the last node
            temp.next.prev = temp.prev;

        return head;
    }

    public static void printList(DLLNode head) {
        DLLNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}


