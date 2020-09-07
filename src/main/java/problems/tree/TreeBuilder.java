package problems.tree;

public class TreeBuilder {

    public static Node getPreDefineBST() {
        /*

                         8
                    /        \
                  4           12
               /    \      /     \
             2      6     10      14
           /   \   / \   /  \   /   \
          1    3  5  7  9   11 13   15
        */
        Node root = new Node(8);

        root.left = new Node(4);
        root.left.left = new Node(2);
//        root.left.left.left = new Node(1);
//        root.left.left.right = new Node(3);

        root.left.right = new Node(6);
//        root.left.right.left = new Node(5);
//        root.left.right.right = new Node(7);

        root.right = new Node(12);

        root.right.left = new Node(10);
//        root.right.left.left = new Node(9);
//        root.right.left.right = new Node(11);

//        root.right.right = new Node(14);
//        root.right.right.left = new Node(13);
//        root.right.right.right = new Node(15);

        return root;
    }

    public static Node getSecondPreDefineBST() {
       /*

                          80
                    /            \
                   40            120
               /      \       /       \
             20       60     100      140
           /   \      / \    /    \   /   \
          10    30  50  70  90   110 130   150
        */
        Node root = new Node(80);

        root.left = new Node(40);
        root.left.left = new Node(20);
//        root.left.left.left = new Node(10);
//        root.left.left.right = new Node(30);

        root.left.right = new Node(60);
//        root.left.right.left = new Node(50);
//        root.left.right.right = new Node(70);

        root.right = new Node(120);

//        root.right.left = new Node(100);
//        root.right.left.left = new Node(90);
//        root.right.left.right = new Node(110);

        root.right.right = new Node(140);
//        root.right.right.left = new Node(130);
//        root.right.right.right = new Node(150);


        return root;
    }

    public static Node getBinaryTree() {

        /**
         *                       1
         *                  /        \
         *                2           3
         *             /    \      /     \
         *            4     5     6       7
         *                   \         /    \
         *                   10       8     9
         *                  /
         *                 11
         *
         * */
        Node root = new Node(1);
        root.left = new Node(2);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(10);
        root.left.right.right.left = new Node(11);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        return root;
    }

    public static void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
}
