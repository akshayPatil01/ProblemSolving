import Util.Node;
import Util.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LLToTree {
    public static void main(String[] args) {
        // Construct the linked list 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Convert the linked list to a binary tree
        Tree root = convert(head, null);

        // Perform level order traversal
        System.out.println("Level order traversal of the constructed binary tree:");
        levelOrderTraversal(root);
    }

    public static Tree convert(Node head, Tree node) {
        // add code here.
        Node temp = head;

        if (node == null) {
            node = new Tree(temp.data);
            temp = temp.next;
        }

        Queue<Tree> childNodes = new LinkedList<>();

        childNodes.offer(node);

        while (temp != null && !childNodes.isEmpty()) {
            Tree curTreeNode = childNodes.poll();

            curTreeNode.left = new Tree(temp.data);
            childNodes.offer(curTreeNode.left);
            temp = temp.next;

            if (temp == null)
                break;

            curTreeNode.right = new Tree(temp.data);
            childNodes.offer(curTreeNode.right);
            temp = temp.next;
        }

        return node;
    }

    public static void levelOrderTraversal(Tree root) {
        if (root == null) {
            return;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
