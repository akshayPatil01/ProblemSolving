import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class HeightOfTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3));

        System.out.print("post order traversal of tree is: ");
        TreeUtil.postOrderTraversal(root);
        System.out.println();

        System.out.println("Height of tree is: " + height(root));

        System.out.println("---------------------------------------------------");

        root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(2, null, 1, 3));

        System.out.print("level order traversal of tree is: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        System.out.println("Height of tree is: " + height(root));
    }

    public static <T> int height(Node<T> root) {
        if (root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
