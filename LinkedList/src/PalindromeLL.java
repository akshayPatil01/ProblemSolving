import Util.LLUtilMethods;
import Util.Node;

import java.util.Arrays;

public class PalindromeLL {
    public static void main(String[] args) {
        Node head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 1));
        System.out.print("LL 1: ");
        LLUtilMethods.printLL(head);

        PalindromeLL p = new PalindromeLL();
        boolean isPalindrome = p.isPalindrome(head);
        System.out.println("Is above LL a palindrome ?: " + isPalindrome);

        System.out.println("-------------------------");

        Node head2 = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 2, 1));
        System.out.print("LL 2: ");
        LLUtilMethods.printLL(head2);

        isPalindrome = p.isPalindrome(head2);
        System.out.println("Is above LL a palindrome ?: " + isPalindrome);
    }

    boolean isPalindrome(Node head) {
        //Your code here
        if (head == null) throw new IllegalArgumentException("LL should not be empty.");

        Node copyHead = copyLinkedList(head);
        Node revHead = reverseLL(head);

        while (copyHead != null) {
            if (copyHead.data != revHead.data) return false;

            copyHead = copyHead.next;
            revHead = revHead.next;
        }

        return true;
    }

    private Node reverseLL(Node head) {
        Node current = head;
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private Node copyLinkedList(Node head) {
        Node newHead = new Node(head.data);

        Node current = newHead;
        head = head.next;
        while (head != null) {
            Node newNode = new Node(head.data);
            head = head.next;
            current.next = newNode;
            current = current.next;
        }

        return newHead;
    }
}
