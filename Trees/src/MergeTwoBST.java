import Util.Node;
import Util.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoBST {
    public static void main(String[] args) {
        Node<Integer> root1 = TreeUtil.createTreeFromLevelOrder(Arrays.asList(5, 3, 6, 2, 4));
        Node<Integer> root2 = TreeUtil.createTreeFromLevelOrder(Arrays.asList(2, 1, 3, null, null, null, 7, 6));

        MergeTwoBST m = new MergeTwoBST();
        System.out.println("Elements of merged BSTs in sorted form: " + m.merge(root1, root2));
    }

    public List<Integer> merge(Node<Integer> root1, Node<Integer> root2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorderTraversal(root1, list1);
        inorderTraversal(root2, list2);

        return mergeSortedLists(list1, list2);
    }

    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }


    private void inorderTraversal(Node<Integer> root, List<Integer> list) {
        if (root == null) return;

        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }
}
