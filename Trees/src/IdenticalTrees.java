import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;
import java.util.Objects;

public class IdenticalTrees {
    public static void main(String[] args) {
        Node<Integer> root1 = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3));
        Node<Integer> root2 = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3, 4));

        System.out.print("Inorder traversal of Tree 1: ");
        TreeUtil.inorderTraversal(root1);
        System.out.println();

        System.out.print("Inorder traversal of Tree 2: ");
        TreeUtil.inorderTraversal(root2);
        System.out.println();

        IdenticalTrees i = new IdenticalTrees();
        System.out.println("Are these two trees identical ?: " + i.isIdentical(root1, root2));
    }

    boolean isIdentical(Node<Integer> root1, Node<Integer> root2) {
        // Code Here
        return inorderTraversal(root1, root2);
    }

    private boolean inorderTraversal(Node<Integer> root1, Node<Integer> root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (!inorderTraversal(root1.left, root2.left))
            return false;

        if (!Objects.equals(root1.data, root2.data))
            return false;

        return inorderTraversal(root1.right, root2.right);
    }


}
