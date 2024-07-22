import Util.Node;
import Util.TreeUtil;

import java.util.Arrays;

public class LargestBST {
    public static void main(String[] args) {
        Node<Integer> root = TreeUtil.createTreeFromLevelOrder(Arrays.asList(137, 481, null, 587, 240, null, 400, 49, null, 139, 791, null, 14, 93, null, 60, 138, null, 601, 267, null, 360, 408, null, 404, 146, null, 558, 731, null, 249, 42, null, 124, 41, null, 373, 386, null, 273, 688, null, 601, 180, null, 772, 271, null, 54, 65, null, 636, 236, null, 739, 598, null, 360, 121, null, 721, 158, null, 181, 282, null, 259, 185, null, 365, 19, null, 76, 29, null, 310, 393, null, 286, 303, null, 556, 186, null, 696, 243, null, 331, 387, null, 594, 79, null, 320, 706, null, 339, 409, null, 173, 155, null, 751, 88, null, 3, 510, null, 411, 385, null, 764, 121, null, 169, 47, null, 602, 195, null, 60, 391, null, 611, 278, null, 180, 416, null, 669, 317, null, 293, 378, null, 435, 58, null, 98, 697, null, 192, 746, null, 656, 445, null, 747, 8, null, 708, 107, null, 296, 598, null, 510, 570, null, 295, 165, null, 450, 427, null, 174, 685, null, 188, 630, null, 436, 701, null, 442, 18, null, 527, 788, null, 565, 331, null, 229, 81, null, 89, 277, null, 147, 607, null, 89, 740, null, 201, 127, null, 263, 774, null, 478, 14, null, 583, 233, null, 47, 193, null, 498, 434, null, 22, 548, null, 472, 572, null, 269, 387, null, 626, 473, null, 459, 503, null, 574, 413, null, 186, 108, null, 348, 601, null, 446, 445, null, 494, 487, null, 508, 65, null, 542, 638, null, 526, 185, null, 190, 189, null, 267, 542, null, 713, 563, null, 250, 460, null, 212, 110, null, 324, 527, null, 475, 576, null, 141, 165, null, 141, 85, null, 86, 400, null, 505, 407, null, 460, 541, null, 187, 750, null, 460, 505, null, 91, 315, null, 392, 279, null, 800, 167, null, 793, 531, null, 535, 656, null, 73, 645, null, 565, 380, null, 694, 485, null, 345, 801, null, 560, 654, null, 183, 156, null, 300, 96, null, 98, 112, null, 62, 590, null, 729, 117, null, 592, 15, null, 604, 761, null, 239, 741, null, 627, 143, null, 669, 36, null, 120, 131, null, 255, 220, null, 533, 670, null, 158, 181, null, 260, 150, null, 481, 354, null, 562, 291, null, 221, 96, null, 661, 235, null, 383, 176, null, 190, 384, null, 357, 680, null, 147, 600, null, 391, 566, null, 85, 341, null, 684, 65, null, 524, 137, null, 437, 624, null, 217, 463, null, 806, 668, null, 620, 692, null, 791, 210, null, 616, 173, null, 644, 757, null, 388, 642, null, 96, 684, null, 175, 634, null, 714, 371, null, 642, 235, null, 625, 786, null, 681, 421, null, 18, 323, null, 559, 250, null, 183, 462, null, 525, 69, null, 502, 357, null, 630, 591, null, 391, 5, null, 200, 253, null, 810, 553, null, 570, 199, null, 232, 425, null, 85, 488, null, 492, 188, null, 199, 124, null, 641, 226, null, 94, 526, null, 170, 309, null, 225, 254, null, 656, 476, null, 502, 802, null, 139, 653, null, 732, 735, null, 592, 563, null, 29, 418, null, 366, 771, null, 779, 27, null, 412, 612, null, 754, 50, null, 498, 504, null, 497, 589, null, 638, 269, null, 402, 1, null, 508, 315, null, 3, 220, null, 221, 148, null, 810, 743, null, 153, 30, null, 411, 595, null, 719, 108, null, 765, 229, null, 313, 236, null, 438, 590, null, 468, 719, null, 528, 484, null, 797, 46, null, 448, 723, null, 453, 379, null, 140, 587, null, 470, 194, null, 695, 666, null, 702, 50, null, 775, 656, null, 811, 534, null, 628, 796, null, 72, 53, null, 443, 646, null, 671, 62, null, 449, 780, null, 443, 688, null, 757, 766, null, 184, 114, null, 676, 245, null, 133, 144, null, 276, 733, null, 658, 65, null, 626, 298, null, 650, 300, null, 4, 164, null, 538, 181, null, 385, 679, null, 22, 649, null, 55, 337, null, 767, 240, null, 279, 745, null, 70, 346, null, 119, 695, null, 772, 600, null, 661, 369, null, 803, 429, null, 726, 530, null, 120, 421));
        System.out.println("Size of Largest BST is: " + largestBst(root));
    }

    static int largestBst(Node<Integer> root) {
        Result result = largestBstLengthHelper(root);
        return result.size;
    }

    private static Result largestBstLengthHelper(Node<Integer> root) {
        if (root == null) return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Result leftTree = largestBstLengthHelper(root.left);
        Result rightTree = largestBstLengthHelper(root.right);

        if ((root.left != null && leftTree.max >= root.data) || (root.right != null && rightTree.min <= root.data) || !leftTree.isBST || !rightTree.isBST) {
            return new Result(false, Math.max(leftTree.size, rightTree.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        rightTree.max = Math.max(root.data, rightTree.max);
        leftTree.min = Math.min(root.data, leftTree.min);

        return new Result(true, 1 + leftTree.size + rightTree.size, leftTree.min, rightTree.max);
    }

}

class Result {
    boolean isBST;
    int size;
    int min;
    int max;

    Result(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}
