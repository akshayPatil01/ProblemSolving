import Util.Node;
import Util.TreeUtil;

import java.util.*;

public class BottomViewOfTree {
    static class Pair<T> {
        Node<T> node;
        int width;

        public Pair(Node<T> node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(14, 14, 3, null, 8, 8, 12, null, 6, 17, 3, null, 1, 11, 10, null, 6, 6, 13, null, 10, 17, 7, null, 11, 7));

        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        BottomViewOfTree b = new BottomViewOfTree();
        ArrayList<Integer> bottomViewList = b.bottomView(root);

        System.out.println("Bottom view of tree is: " + bottomViewList);
    }

    public <T> ArrayList<T> bottomView(Node<T> root) {
        ArrayList<T> bottomViewList = new ArrayList<>();

        if (root == null) return bottomViewList;
        TreeMap<Integer, T> widthNodeMap = new TreeMap<>();

        printBottomView(root, widthNodeMap);
        bottomViewList.addAll(widthNodeMap.values());

        return bottomViewList;
    }

    private <T> void printBottomView(Node<T> root, TreeMap<Integer, T> widthNodeMap) {
        Queue<Pair<T>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<T> curPair = queue.poll();

            int curWidth = curPair.width;
            Node<T> curNode = curPair.node;

            widthNodeMap.put(curWidth, curNode.data);

            if (curNode.left != null)
                queue.add(new Pair<>(curNode.left, curWidth - 1));

            if (curNode.right != null)
                queue.add(new Pair<>(curNode.right, curWidth + 1));
        }
    }
}
