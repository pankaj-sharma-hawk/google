package problems.done;

import problems.tree.Node;
import problems.tree.TreeBuilder;

public class kThSmallestElementBST {

    public static void main(String[] args) {
        Node root = TreeBuilder.getPreDefineBST();
        TreeBuilder.printTree(root);
        System.out.println();
        System.out.println(MorrisTraversal.getKthSmallestElementBST(root, 15));

    }

    private static int count = 0;

    public static int getKthSmallestElementInBST(Node root, int k) {
        count = 1;
        return getKthSmallestValue(root, k);
    }

    public static int getKthSmallestValue(Node root, int k) {
        if (root == null)
            return -1;
        int leftValue = getKthSmallestValue(root.left, k);
        if (leftValue != -1) {
            return leftValue;
        }
        if (count == k)
            return root.data;
        else
            count++;
        return getKthSmallestValue(root.right, k);
    }


}
