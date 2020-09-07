package problems.done;

import problems.tree.Node;
import problems.tree.TreeBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachableFromNodeTree {

    public static void main(String[] args) {
        Node root = TreeBuilder.getBinaryTree();

        printTreeStructure(getReachableNodeFromTree(root, root.left.right.right));
    }

    public static List<Integer> getReachableNodeFromTree(Node root, Node node) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        buildTreeUtil(root, node, result, queue);
        while (!queue.isEmpty()) {
            addToQueueAndResultList(null, queue, result);
        }
        return result;
    }

    private static int buildTreeUtil(Node root, Node node, List<Integer> list, Queue<Node> queue) {
        if (root == null)
            return 0;
        if (root == node) {
            list.add(root.data);
            list.add(null); // For Separator
            addToQueue(queue, root);
            return 1;
        }
        int left = buildTreeUtil(root.left, node, list, queue);
        if (left == 1) {
            addToQueueAndResultList(root, queue, list);
            if (root.right != null)
                queue.add(root.right);
            return 1;
        }
        int right = buildTreeUtil(root.right, node, list, queue);
        if (right == 1) {
            addToQueueAndResultList(root, queue, list);
            if (root.left != null)
                queue.add(root.left);
            return 1;
        }
        return 0;

    }

    private static void addToQueueAndResultList(Node root, Queue<Node> queue, List<Integer> list) {
        int size = queue.size();
        while (size != 0) {
            Node temp = queue.remove();
            list.add(temp.data);
            addToQueue(queue, temp);
            size--;
        }
        if (root != null)
            list.add(root.data);
        list.add(null); // For Separator
    }

    private static void addToQueue(Queue<Node> queue, Node node) {
        if (node.left != null)
            queue.add(node.left);
        if (node.right != null)
            queue.add(node.right);
    }

    private static void printTreeStructure(List<Integer> list) {
        for (Integer value : list) {
            if (value == null)
                System.out.println();
            else
                System.out.print(value + " ");
        }
    }
}

