import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class RemoveHalfNodes {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 6, 2, null, 1, 8, 2, null, 1, 2, 4, null, 4));
        System.out.print("Level order traversal of tree: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        RemoveHalfNodes r = new RemoveHalfNodes();
        root = r.RemoveHalfNodesTree(root);

        System.out.print("Level order traversal after removing half Nodes: ");
        TreeUtil.levelOrderTraversal(root);
    }

    public Node<Integer> RemoveHalfNodesTree(Node<Integer> root) {
        if (root == null) return null;

        root.left = RemoveHalfNodesTree(root.left);
        root.right = RemoveHalfNodesTree(root.right);

        if (root.left != null && root.right == null) {
            return root.left;
        } else if (root.left == null && root.right != null) {
            return root.right;
        }

        return root;
    }
}
