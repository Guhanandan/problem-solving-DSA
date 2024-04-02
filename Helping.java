public class Helping {
    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class TopView {
        Node root;

        TopView() {
            this.root = null;
        }

        int sumTree(Node root) {
            if (root == null) {
                return 0;
            }
            return root.data + sumTree(root.left) + sumTree(root.right);
        }

        public static void main(String arg[]) {
            TopView tree = new Helping.TopView();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);

            tree.root.left.left = new Node(5);
            tree.root.left.right = new Node(6);
            tree.root.right.left = new Node(8);
            tree.root.right.right = new Node(9);

            int ans = tree.sumTree(tree.root);
            System.out.println(ans);
        }
    }
}
