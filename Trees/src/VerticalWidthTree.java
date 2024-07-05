import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class VerticalWidthTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7, null, null, null, null, 8, null, null, 9));

        VerticalWidthTree v = new VerticalWidthTree();
        int verticalWidth = v.verticalWidth(root);

        System.out.print("Inorder Traversal of tree ->   ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        System.out.println("Vertical width of tree is:  " + verticalWidth);
    }

    private int maxLeftWidth = 0;
    private int maxRightWidth = 0;

    public int verticalWidth(Node<Integer> root) {
        if (root == null)
            return 0;

        findWidth(root, 0);

        return maxRightWidth - maxLeftWidth + 1;
    }

    private void findWidth(Node<Integer> root, int curWidth) {
        if (root == null) return;

        if (curWidth < maxLeftWidth)
            maxLeftWidth = curWidth;

        if (curWidth > maxRightWidth)
            maxRightWidth = curWidth;

        findWidth(root.left, curWidth - 1);
        findWidth(root.right, curWidth + 1);
    }
}
