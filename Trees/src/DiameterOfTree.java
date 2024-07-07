import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class DiameterOfTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6));

        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        DiameterOfTree b = new DiameterOfTree();
        b.diameter(root);

        System.out.println("Diameter of BST: " + b.MAX_WIDTH);
    }

    private int MAX_WIDTH = 0;

    public int diameter(Node<Integer> root) {
        if (root == null) return 0;

        int leftWidth = diameter(root.left);
        int rightWidth = diameter(root.right);

        int CUR_WIDTH = leftWidth + rightWidth + 1;

        if (CUR_WIDTH > MAX_WIDTH) MAX_WIDTH = CUR_WIDTH;

        return Math.max(leftWidth, rightWidth) + 1;
    }
}
