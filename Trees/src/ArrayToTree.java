import Util.Node;
import Util.TreeUtil;

public class ArrayToTree {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};

        ArrayToTree a = new ArrayToTree();
        Node<Integer> root = a.sortedArrayToBST(nums);

        System.out.print("Level order traversal of built tree: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        System.out.println("Is built tree balanced ?: " + ArrayToTree.isBalanced(root));
    }

    public Node<Integer> sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private Node<Integer> buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        Node<Integer> node = new Node<>(nums[mid]);

        node.left = buildBST(nums, start, mid - 1);
        node.right = buildBST(nums, mid + 1, end);

        return node;
    }

    // Helper method to check if the tree is height-balanced
    public static boolean isBalanced(Node<Integer> root) {
        return height(root) != -1;
    }

    private static int height(Node<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
