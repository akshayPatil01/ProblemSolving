package Util;

import java.util.List;

public class LLUtilMethods {
    public static <T> Node<T> createLL(List<T> elements) {
        if (elements.isEmpty()) return null;

        Node<T> temp = new Node<>(null);
        Node<T> head = temp;

        for (T el : elements) {
            Node<T> newNode = new Node<>(el);
            temp.next = newNode;

            temp = newNode;
        }

        return head.next;
    }

    public static <T> Node<T> createLLWithLoop(List<T> elements, int sizeOfLoop) {
        Node<T> head = createLL(elements);
        assert head != null;

        System.out.print("Original Looped LL: ");
        printLL(head);

        int length = getLength(head);

        Node<T> startNode = head;
        int start = length;
        while (start > 1) {
            startNode = startNode.next;
            start--;
        }

        int endOfLoop = length - sizeOfLoop;
        Node<T> endNode = head;
        while (endOfLoop > 0) {
            endNode = endNode.next;
            endOfLoop--;
        }

        startNode.next = endNode;
        System.out.println("Loop Starts at -> " + startNode.data + " & End at -> " + endNode.data);

        return head;
    }

    private static <T> int getLength(Node<T> root) {
        int length = 0;

        while (root != null) {
            root = root.next;
            length++;
        }

        return length;
    }

    public static <T> DLLNode<T> createDLL(List<T> elements) {
        if (elements.isEmpty()) return null;

        DLLNode<T> head = null;

        for (T el : elements) {
            head = appendDLL(head, el);
        }

        return head;
    }

    private static <T> DLLNode<T> appendDLL(DLLNode<T> head, T new_data) {
        DLLNode<T> new_node = new DLLNode<>(new_data);
        DLLNode<T> last = head;

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

    public static <T> void printDLL(DLLNode<T> head) {
        DLLNode<T> node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static <T> void printLL(Node<T> head) {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
