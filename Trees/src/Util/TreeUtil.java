package Util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static <T> void inorderTraversal(Node<T> root) {
        if (root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static <T> void preOrderTraversal(Node<T> root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static <T> void postOrderTraversal(Node<T> root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static <T> void levelOrderTraversal(Node<T> root) {
        if (root == null) return;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();

            if (node == null)
                continue;

            System.out.print(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

//    public static <T> Node<T> createTree(List<T> elements) {
//        Node<T> root = null;
//        for(T el: elements) {
//            if(root == null) root = new Node<>(el);
//
//            root.left =
//            createTree(root.left);
//            createTree(root.right);
//        }
//
//        return root;
//    }

}
