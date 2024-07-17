import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;

public class TreeFromParentArray {
    public static void main(String[] args) {
        TreeFromParentArray t = new TreeFromParentArray();

        int[] parent = new int[]{-1, 0, 0, 1, 1, 3, 5};
        Node<Integer> head = t.createTree(parent);

        TreeUtil.levelOrderTraversal(head);
    }

    public Node<Integer> createTree(int[] parent) {
        int n = parent.length;
        if (n == 0) return null;

        ArrayList<Node<Integer>> nodes = new ArrayList<>(n);
        Node<Integer> root = null;

        for (int i = 0; i < n; i++) {
            nodes.add(i, new Node<>(i));
        }

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = nodes.get(i);
            } else {
                Node<Integer> parentNode = nodes.get(parent[i]);
                if (parentNode.left == null) {
                    parentNode.left = nodes.get(i);
                } else {
                    parentNode.right = nodes.get(i);
                }
            }
        }

        return root;
    }

    // ** ALTERNATIVE APPROACH ** //

//    public Node<Integer> createTree(int[] parent) {
//        if (parent.length == 0)
//            return null;
//
//        Queue<Node<Integer>> q = new LinkedList<>();
//
//        // parentChildMap
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//
//        createMap(map, parent);
//
//        int headData = map.get(-1).get(0);
//        Node<Integer> head = new Node<>(headData);
//        q.add(head);
//
//        while (!q.isEmpty()) {
//            Node<Integer> node = q.poll();
//
//            ArrayList<Integer> child = map.get(node.data);
//
//            if (child == null)
//                continue;
//
//            if (!child.isEmpty()) {
//                node.left = new Node<>(child.get(0));
//                q.add(node.left);
//
//                if (child.size() == 2) {
//                    node.right = new Node<>(child.get(1));
//                    q.add(node.right);
//                }
//            }
//        }
//
//        return head;
//    }
//
//    private void createMap(Map<Integer, ArrayList<Integer>> map, int[] parent) {
//        for (int i = 0; i < parent.length; i++) {
//            ArrayList<Integer> childList = map.getOrDefault(parent[i], new ArrayList<>());
//            childList.add(i);
//            map.put(parent[i], childList);
//        }
//    }
}
