import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AncestorsBT {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(1, 2, 3));

        System.out.print("Level order traversal of tree: ");
        TreeUtil.levelOrderTraversal(root);
        System.out.println();

        int target = 2;

        AncestorsBT a = new AncestorsBT();
        ArrayList<Integer> ancestorList = a.Ancestors(root, target);
        System.out.println("Ancestors of target " + target + ": " + ancestorList);
    }

    private final ArrayList<Integer> ancestorsList = new ArrayList<>();

    public ArrayList<Integer> Ancestors(Node<Integer> root, int target) {
        // add your code here
        findAncestors(root, target, new ArrayList<>());
        Collections.reverse(ancestorsList);
        return ancestorsList;
    }

    private void findAncestors(Node<Integer> node, int target, ArrayList<Integer> curList) {
        if (node == null || !ancestorsList.isEmpty()) return;

        if (node.data == target) {
            ancestorsList.addAll(curList);
            return;
        }

        curList.add(node.data);

        findAncestors(node.left, target, curList);
        findAncestors(node.right, target, curList);

        curList.remove(Integer.valueOf(node.data));
    }
}
