class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class binaryTree {

    Node root;
    binaryTree(){
        root = null;
    }

    public void inOrderedTraversal(Node root){
        if(root==null){
            return ;
        }
        inOrderedTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderedTraversal(root.right);
    }

    public void preOrderedTraversal(Node root){
        if(root==null){
            return ;
        }
        System.out.print(root.data+" ");
        preOrderedTraversal(root.left);
        preOrderedTraversal(root.right);
    }

    public void postOrderedTraversal(Node root){
        if(root==null){
            return ;
        }
        
        postOrderedTraversal(root.left);
        postOrderedTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public int findSum(Node node){
        if(node.left==null && node.right==null){
            return node.data;
        }
        int data = findSum(node.left);
        findSum(node.right);

        return data;
    }

    public static void main(String[] arg){
        binaryTree tree = new binaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(15);
        tree.root.right = new Node(25);
        tree.root.left.left = new Node(11);
        tree.root.left.right = new Node(17);
        tree.root.right.left = new Node(23);
        tree.root.right.right = new Node(27);
        tree.root.left.left.left = new Node(19);

        /**System.out.println("Inordered Traversal: ");
        tree.inOrderedTraversal(tree.root);
        System.out.println();
        System.out.println("preordered Traversal: ");
        tree.preOrderedTraversal(tree.root);
        System.out.println();
        System.out.println("postordered Traversal: ");
        tree.postOrderedTraversal(tree.root);**/
        System.out.println(tree.findSum(tree.root));
    }
    
}
