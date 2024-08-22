import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        LeftViewTree l = new LeftViewTree();
        System.out.println("Left of binary tree: " + l.leftView(root));
    }

    ArrayList<Integer> leftView(Node<Integer> root) {
        ArrayList<Integer> arrList = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair record = q.remove();

            int height = record.height;
            Node<Integer> node = record.node;

            if (arrList.size() == height)
                arrList.add(node.data);

            if (node.left != null)
                q.add(new Pair(node.left, height + 1));

            if (node.right != null)
                q.add(new Pair(node.right, height + 1));
        }

        return arrList;
    }
}

class Pair {
    Node<Integer> node;
    int height;

    Pair(Node<Integer> node, int height) {
        this.node = node;
        this.height = height;
    }
}