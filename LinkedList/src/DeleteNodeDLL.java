public class DeleteNodeDLL {
    Node head; // head of the list

    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

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
        Node new_node = new Node(new_data);
        Node last = head;

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

    public Node deleteNode(Node head, int x) {
        Node temp = head;

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

    public static void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}


