import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(14, 14, 3, null, 8, 8, 12, 17, 3, null, 1, 11, 10, null, 6, 6, 13, null, 10, 17, 7, null, 11, 7));

        System.out.print("Level Traversal of tree: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        LeftViewOfTree b = new LeftViewOfTree();
        ArrayList<Integer> leftViewList = b.printLeftView(root);

        System.out.println("Left view of tree is: " + leftViewList);
    }

    public <T> ArrayList<T> printLeftView(Node<T> root) {
        ArrayList<T> leftViewList = new ArrayList<>();
        if (root == null) return leftViewList;

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int curSize = queue.size();

            leftViewList.add(queue.peek().data);

            while (curSize > 0) {
                Node<T> curNode = queue.poll();

                assert curNode != null;
                if (curNode.left != null)
                    queue.add(curNode.left);

                if (curNode.right != null)
                    queue.add(curNode.right);

                curSize--;
            }
        }

        return leftViewList;
    }
}
