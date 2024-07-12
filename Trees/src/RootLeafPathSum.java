import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class RootLeafPathSum {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int target = 10;
        System.out.print("Level Order Traversal of tree: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        RootLeafPathSum r = new RootLeafPathSum();
        System.out.println("Is there a path from root to leaf with sum " + target + " ?: " + r.hasPathSum(root, target));

        target = 12;
        System.out.println("Is there a path from root to leaf with sum " + target + " ?: " + r.hasPathSum(root, target));
    }

    boolean hasPathSum(Node<Integer> root, int target) {
        return preorderTraversal(root, target, 0);
    }

    private boolean preorderTraversal(Node<Integer> root, int target, int curSum) {
        if (root == null) return false;

        curSum += root.data;
        if (root.left == null && root.right == null && curSum == target)
            return true;

        if (preorderTraversal(root.left, target, curSum))
            return true;

        return preorderTraversal(root.right, target, curSum);
    }
}
