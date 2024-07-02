import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;
import java.util.Objects;

public class PalindromeLL {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 1));
        System.out.print("LL 1: ");
        LLUtilMethods.printLL(head);

        PalindromeLL p = new PalindromeLL();
        boolean isPalindrome = p.isPalindrome(head);
        System.out.println("Is above LL a palindrome ?: " + isPalindrome);

        System.out.println("-------------------------");

        Node<Integer> head2 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 2, 1));
        System.out.print("LL 2: ");
        LLUtilMethods.printLL(head2);

        isPalindrome = p.isPalindrome(head2);
        System.out.println("Is above LL a palindrome ?: " + isPalindrome);
    }

    boolean isPalindrome(Node<Integer> head) {
        //Your code here
        if (head == null) throw new IllegalArgumentException("LL should not be empty.");

        Node<Integer> copyHead = copyLinkedList(head);
        Node<Integer> revHead = reverseLL(head);

        while (copyHead != null) {
            if (!Objects.equals(copyHead.data, revHead.data)) return false;

            copyHead = copyHead.next;
            revHead = revHead.next;
        }

        return true;
    }

    private Node<Integer> reverseLL(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev = null;
        Node<Integer> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private Node<Integer> copyLinkedList(Node<Integer> head) {
        Node<Integer> newHead = new Node<>(head.data);

        Node<Integer> current = newHead;
        head = head.next;
        while (head != null) {
            Node<Integer> newNode = new Node<>(head.data);
            head = head.next;
            current.next = newNode;
            current = current.next;
        }

        return newHead;
    }
}
