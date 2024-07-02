import Util.LLUtilMethods;
import Util.Node;
import Util.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LLToTree {
    public static void main(String[] args) {
        Node<Integer> head = LLUtilMethods.createLL(Arrays.asList(1, 2, 3, 4, 5, 10, 6));
        System.out.print("LL: ");
        LLUtilMethods.printLL(head);

        System.out.println();
        Tree<Integer> root = convert(head, null);

        System.out.println("Level order traversal of the constructed binary tree: ");
        levelOrderTraversal(root);
    }

    public static Tree<Integer> convert(Node<Integer> head, Tree<Integer> node) {
        // add code here.
        Node<Integer> temp = head;

        if (node == null) {
            node = new Tree<>(temp.data);
            temp = temp.next;
        }

        Queue<Tree<Integer>> childNodes = new LinkedList<>();

        childNodes.offer(node);

        while (temp != null && !childNodes.isEmpty()) {
            Tree<Integer> curTreeNode = childNodes.poll();

            curTreeNode.left = new Tree<>(temp.data);
            childNodes.offer(curTreeNode.left);
            temp = temp.next;

            if (temp == null) break;

            curTreeNode.right = new Tree<>(temp.data);
            childNodes.offer(curTreeNode.right);
            temp = temp.next;
        }

        return node;
    }

    public static void levelOrderTraversal(Tree<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree<Integer> current = queue.poll();
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
