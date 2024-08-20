import Util.Node;
import Util.TreeUtil;

import java.util.*;

public class BurningTree {
    public static void main(String[] args) {
        int start = 3;
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 5, 3, null, 4, 10, 6, 9, 2));

        BurningTree b = new BurningTree();
        System.out.println("Time taken to burn the tree: " + b.burningTree(root, start));
    }

    public int burningTree(Node<Integer> root, int target) {
        Map<Integer, Node<Integer>> parentMap = new HashMap<>();
        markParents(root, parentMap);                               // mark parents

        Node<Integer> targetNode = findTarget(root, target);        // find target

        return burnTree(root, targetNode, parentMap);               // bfs - return time
    }

    private void markParents(Node<Integer> root, Map<Integer, Node<Integer>> parentMap) {
        if (root == null) return;

        if (root.left != null) {
            parentMap.put(root.left.data, root);
            markParents(root.left, parentMap);
        }

        if (root.right != null) {
            parentMap.put(root.right.data, root);
            markParents(root.right, parentMap);
        }
    }

    private Node<Integer> findTarget(Node<Integer> root, int target) {
        if (root == null) return null;

        if (root.data == target) return root;

        Node<Integer> targetNode = findTarget(root.right, target);
        if (targetNode != null) return targetNode;

        return findTarget(root.left, target);
    }

    private int burnTree(Node<Integer> root, Node<Integer> target, Map<Integer, Node<Integer>> map) {
        if (root == null) return 0;

        int time = 0;

        Set<Integer> visited = new HashSet<>();
        Queue<Node<Integer>> q = new LinkedList<>();

        q.add(target);
        visited.add(target.data);

        while (!q.isEmpty()) {
            boolean didBurned = false;
            int curSize = q.size();
            int burnedCount = 0;

            while (burnedCount < curSize) {
                burnedCount++;

                Node<Integer> node = q.poll();

                assert node != null;
                if (node.left != null && !visited.contains(node.left.data)) {
                    q.add(node.left);
                    visited.add(node.left.data);
                    didBurned = true;
                }

                if (node.right != null && !visited.contains(node.right.data)) {
                    q.add(node.right);
                    visited.add(node.right.data);
                    didBurned = true;
                }

                Node<Integer> parent = map.get(node.data);
                if (parent != null && !visited.contains(parent.data)) {
                    q.add(parent);
                    visited.add(parent.data);
                    didBurned = true;
                }
            }

            if (didBurned)
                time++;
        }

        return time;
    }
}
