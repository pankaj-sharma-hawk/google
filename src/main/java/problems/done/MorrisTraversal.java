package problems.done;

import problems.tree.Node;
import problems.tree.TreeBuilder;

public class MorrisTraversal {

    public static void main(String[] args) {
        Node root = TreeBuilder.getPreDefineBST();
        TreeBuilder.printTree(root);
        System.out.println();

        getMorrisInorderTree(root);
    }

    public static void getMorrisInorderTree(Node root) {
        while (root != null) {

            Node temp = root;
            if (temp.left != null) {
                temp = temp.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                } else {
                    System.out.print(root.data + " ");
                    temp.right = null;
                    root = root.right;
                    continue;
                }
            }
            if (root.left != null) {
                root = root.left;
            } else {
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    public static int getKthSmallestElementBST(Node root, int k) {
        int count = 0;
        while (root != null) {

            Node temp = root;
            if (temp.left != null) {
                temp = temp.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                } else {
                    count++;
                    if (count == k) {
                        return root.data;
                    }
                    temp.right = null;
                    root = root.right;
                    continue;
                }
            }
            if (root.left != null) {
                root = root.left;
            } else {
                count++;
                if (count == k) {
                    return root.data;
                }
                root = root.right;
            }
        }
        return -1;
    }


}
