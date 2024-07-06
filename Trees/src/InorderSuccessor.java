import Util.SNode;
import Util.TreeUtil;

import java.util.Arrays;

public class InorderSuccessor {

    public static void main(String[] args) {
        SNode root = TreeUtil.createSTreeFromLevelOrder(Arrays.asList(2, 1, 7, null, null, 6, 8, 4, null, null, null, 3, 5));
        InorderSuccessor i = new InorderSuccessor();
        i.populateNext(root);
    }

    public void populateNext(SNode root) {
        // code here
        SNode[] prev = new SNode[1];
        prev[0] = null;

        inorderTraversal(root, prev);

        TreeUtil.inorderSuccessorTraversal(root);
    }

    private void inorderTraversal(SNode root, SNode[] prev) {
        if (root == null) return;

        inorderTraversal(root.left, prev);

        if (prev[0] != null)
            prev[0].next = root;

        prev[0] = root;

        inorderTraversal(root.right, prev);
    }
}
