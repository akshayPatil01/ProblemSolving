package Util;

import java.util.Arrays;
import java.util.List;

public class LLUtilMethods {
    public static Node createLL(List<Integer> elements) {
        if (elements.isEmpty()) return null;

        Node temp = new Node(-1);
        Node head = temp;

        for (int el : elements) {
            Node newNode = new Node(el);
            temp.next = newNode;

            temp = newNode;
        }

        return head.next;
    }

    public static Node createLLWithLoop() {
        Node head = createLL(Arrays.asList(1, 2, 3, 4, 5));

        assert head != null;
        head.next.next.next.next.next = head.next.next;

        System.out.println("Original Looped LL: " + "1 2 3 4 5 -> 3 ...");
        return head;
    }

    public static DLLNode createDLL(List<Integer> elements) {
        if (elements.isEmpty()) return null;

        DLLNode head = null;

        for (int el : elements) {
            head = appendDLL(head, el);
        }

        return head;
    }

    private static DLLNode appendDLL(DLLNode head, int new_data) {
        DLLNode new_node = new DLLNode(new_data);
        DLLNode last = head;

        new_node.next = null;

        if (head == null) {
            new_node.prev = null;
            return new_node;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
        new_node.prev = last;

        return head;
    }

    public static void printDLList(DLLNode head) {
        DLLNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void printLL(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
