package problems.done;

import problems.tree.Node;
import problems.tree.TreeBuilder;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeSameLevel {
    public static void main(String[] args) {
        Node root = TreeBuilder.getBinaryTree();
        connectSameLevelNodes(root);
        printSibling(root);
    }

    public static void connectSameLevelNodes(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) {
                if (queue.isEmpty())
                    break;
                queue.add(null);
                continue;
            }
            temp.nextSibling = queue.peek();

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public static void printSibling(Node root) {
        while (root != null) {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.nextSibling;
            }
            System.out.println();
            root = root.left;
        }
    }
}
