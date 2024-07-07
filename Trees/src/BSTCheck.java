import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class BSTCheck {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 1, 6));
        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);

        System.out.println();

        BSTCheck b = new BSTCheck();
        System.out.println("Is given tree a BST ?: " + b.isBST(root));
    }

    ArrayList<Integer> nodeList = new ArrayList<>();

    public boolean isBST(Node<Integer> root) {
        if (root == null || root.data == null)
            return true;

        inorderTraversal(root);

        int prev = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            int cur = nodeList.get(i);
            if (cur <= prev)
                return false;

            prev = cur;
        }

        return true;
    }

    private void inorderTraversal(Node<Integer> root) {
        if (root == null) return;

        inorderTraversal(root.left);
        nodeList.add(root.data);
        inorderTraversal(root.right);
    }
}
