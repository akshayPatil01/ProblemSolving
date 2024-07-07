import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class BalancedTreeCheck {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(10, 20, 30, 40, 60, null, null, 70));

        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        BalancedTreeCheck b = new BalancedTreeCheck();
        b.isBalanced(root);
        System.out.println("Is current tree balanced ?: " + b.isTreeBalanced);
    }

    private boolean isTreeBalanced = true;

    private int isBalanced(Node<Integer> root) {
        if (!isTreeBalanced) return 0;

        if (root == null) return 0;

        int leftHeight = isBalanced(root.left);
        int rightHeight = isBalanced(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            isTreeBalanced = false;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
