import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class BoundaryTraversalOfTree {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(17, null, 1, null, 9, null, 2, null, 11, null, 16, null, 8, null, 5, null, 3, null, 10, null, 13, null, 5, null, 13, null, 7, null, 10, null, 4, null, 7, null, 2, null, 12, null, 16));

        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        BoundaryTraversalOfTree b = new BoundaryTraversalOfTree();
        ArrayList<Integer> boundaryNodesList = b.boundaryTraversal(root);

        System.out.println("Boundary Traversal of tree: " + boundaryNodesList);
    }

    private final ArrayList<Integer> boundaryNodes = new ArrayList<>();

    public ArrayList<Integer> boundaryTraversal(Node<Integer> root) {
        if (root == null) return boundaryNodes;
        boundaryNodes.add(root.data);

        leftBoundaryTraversal(root.left);
        leafNodeTraversal(root.left);
        leafNodeTraversal(root.right);
        rightBoundaryTraversal(root.right);

        return boundaryNodes;
    }

    private void leftBoundaryTraversal(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) return;

        boundaryNodes.add(root.data);
        leftBoundaryTraversal(Objects.requireNonNullElseGet(root.left, () -> root.right));
    }

    private void rightBoundaryTraversal(Node<Integer> root) {
        if (root == null || (root.left == null && root.right == null)) return;

        rightBoundaryTraversal(Objects.requireNonNullElseGet(root.right, () -> root.left));
        boundaryNodes.add(root.data);
    }

    private void leafNodeTraversal(Node<Integer> root) {
        if (root == null) return;

        if (root.left == null && root.right == null) boundaryNodes.add(root.data);

        leafNodeTraversal(root.left);
        leafNodeTraversal(root.right);
    }
}
