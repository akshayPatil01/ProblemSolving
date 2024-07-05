import Util.Node;
import Util.TreeUtil;

import java.util.*;

public class DuplicateSubtrees {
    public static void main(String[] args) {
        // Construct the tree
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.right.left = new Node<>(2);
        root.right.right = new Node<>(4);
        root.right.left.left = new Node<>(4);

        DuplicateSubtrees d = new DuplicateSubtrees();

        List<Node<Integer>> solutionList = d.printAllDuplicates(root);

        solutionList.sort(Comparator.comparingInt(head -> head.data));

        for (Node<Integer> n : solutionList) {
            TreeUtil.preOrderTraversal(n);
            System.out.println();
        }
    }

    private List<Node<Integer>> duplicateHeadList;
    private Map<String, Integer> countMap;

    public List<Node<Integer>> printAllDuplicates(Node<Integer> root) {
        duplicateHeadList = new ArrayList<>();
        countMap = new HashMap<>();

        serialize(root);

        return duplicateHeadList;
    }

    private String serialize(Node<Integer> head) {
        if (head == null)
            return "#";

        String serial = head.data + "," + serialize(head.left) + "," + serialize(head.right);
        countMap.put(serial, countMap.getOrDefault(serial, 0) + 1);

        if (countMap.get(serial) == 2) {
            duplicateHeadList.add(head);
        }

        return serial;
    }
}
