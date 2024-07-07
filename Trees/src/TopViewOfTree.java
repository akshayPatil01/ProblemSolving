import Util.Node;
import Util.TreeUtil;

import java.util.*;

public class TopViewOfTree {
    static class Pair<T> {
        Node<T> node;
        int width;

        public Pair(Node<T> node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(14, 14, 3, null, 8, 8, 12, 17, 3, null, 1, 11, 10, null, 6, 6, 13, null, 10, 17, 7, null, 11, 7));

        System.out.print("Inorder Traversal of tree: ");
        TreeUtil.inorderTraversal(root);
        System.out.println();

        TopViewOfTree b = new TopViewOfTree();
        ArrayList<Integer> topViewList = b.topView(root);

        System.out.println("Top view of tree is: " + topViewList);
    }

    public <T> ArrayList<T> topView(Node<T> root) {
        ArrayList<T> topViewList = new ArrayList<>();

        if (root == null) return topViewList;
        TreeMap<Integer, T> widthNodeMap = new TreeMap<>();

        printTopView(root, widthNodeMap);
        topViewList.addAll(widthNodeMap.values());

        return topViewList;
    }

    private <T> void printTopView(Node<T> root, TreeMap<Integer, T> widthNodeMap) {
        Queue<Pair<T>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<T> curPair = queue.poll();

            int curWidth = curPair.width;
            Node<T> curNode = curPair.node;

            widthNodeMap.computeIfAbsent(curWidth, k -> curNode.data);

            if (curNode.left != null)
                queue.add(new Pair<>(curNode.left, curWidth - 1));

            if (curNode.right != null)
                queue.add(new Pair<>(curNode.right, curWidth + 1));
        }
    }
}
