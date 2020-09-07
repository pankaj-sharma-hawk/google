package problems.done;

import problems.tree.Node;
import problems.tree.TreeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Merge2BST {
    public static void main(String[] args) {

        Node root1 = TreeBuilder.getPreDefineBST();
        Node root2 = TreeBuilder.getSecondPreDefineBST();
        System.out.println(mergeBST(root1, root2));
    }

    public static List<Integer> mergeBST(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean isStackEmpty = false;
        do {
            while (root1 != null) {
                stack1.add(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                stack2.add(root2);
                root2 = root2.left;
            }
            if (stack1.isEmpty() && stack2.empty()) {
                isStackEmpty = true;
            }
            if ((!stack1.isEmpty() && !stack2.isEmpty())) {
                if ((stack1.peek().data == stack2.peek().data)) {
                    root1 = setValueAndReturnNode(stack1.pop(), result);
                    root2 = setValueAndReturnNode(stack2.pop(), result);
                } else if ((stack1.peek().data < stack2.peek().data)) {
                    root1 = setValueAndReturnNode(stack1.pop(), result);
                } else {
                    root2 = setValueAndReturnNode(stack2.pop(), result);
                }
            } else {
                if ((!stack1.isEmpty() && stack2.isEmpty())) {
                    root1 = setValueAndReturnNode(stack1.pop(), result);
                } else if ((stack1.isEmpty() && !stack2.isEmpty())) {
                    root2 = setValueAndReturnNode(stack2.pop(), result);
                }
            }

        } while (!isStackEmpty);
        return result;
    }

    private static Node setValueAndReturnNode(Node node, List<Integer> integerList) {
        integerList.add(node.data);
        return node.right;
    }
}
