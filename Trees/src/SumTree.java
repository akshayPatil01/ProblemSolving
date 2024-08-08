import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class SumTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(70, 20, 30, 10, 10));
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        SumTree s = new SumTree();
        System.out.println("Is it as Sum Tree ?: " + s.isSumTree(root));

        Node<Integer> root2 = TreeUtil.createTreeFromLevelOrder(Arrays.asList(10, 20, 30, 10, 10));
        TreeUtil.levelOrderTraversal(root2);
        System.out.println();

        System.out.println("Is it as Sum Tree ?: " + s.isSumTree(root2));
    }

    boolean isSumTree(Node<Integer> root) {
        return postOrderTraversal(root);
    }

    private boolean postOrderTraversal(Node<Integer> root) {
        if (isLeafNode(root)) return true;

        int leftSum = 0;

        if (root.left != null) {
            if (postOrderTraversal(root.left)) {
                leftSum = isLeafNode(root.left) ? root.left.data : 2 * root.left.data;
            } else return false;
        }

        int rightSum = 0;

        if (root.right != null) {
            if (postOrderTraversal(root.right)) {
                rightSum = isLeafNode(root.right) ? root.right.data : 2 * root.right.data;
            } else return false;
        }

        int rootData = root.data;

        return rootData == rightSum + leftSum;
    }

    private boolean isLeafNode(Node<Integer> node) {
        return node.left == null && node.right == null;
    }
}
