public class IdenticalLinkedList {
    public static void main(String[] args) {
        IdenticalLinkedList i = new IdenticalLinkedList();

        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println("Are LinkedLists Identical ?: " + i.areIdentical(head1, head2));
    }

    public boolean areIdentical(Node head1, Node head2) {
        // write your code here
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == null && head2 == null;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
