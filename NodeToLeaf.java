import java.util.ArrayList;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class NodeToLeaf {
    Node root;
    NodeToLeaf(){
        root = null;
    }

    public void helper(Node root,ArrayList<Integer> path,ArrayList<ArrayList<Integer>> ans){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
            return ;
        }
        helper(root.left,new ArrayList<>(path) ,ans);
        helper(root.right,new ArrayList<>(path) ,ans);
    }

    public Node binarySearchTree(Node root,int x){
        // if(root==null){
        //     return ;
        // }
        if(root.data == x || root==null){
            return root;
        }
        if(root.data>x){
            return binarySearchTree(root.left, x);
        }
        else{
            return binarySearchTree(root.right, x);
        }
    }

    public ArrayList<ArrayList<Integer>> nodeToLeafPath(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        helper(root,new ArrayList<Integer>(),ans);
        return ans;
    }
    public static void main(String arg[]){
        
        NodeToLeaf tree = new NodeToLeaf();
        tree.root = new Node(20);
        tree.root.left = new Node(15);
        tree.root.right = new Node(25);

        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(17);
        tree.root.right.left = new Node(21);
        tree.root.right.right = new Node(27);

        // tree.root.right.right.right = new Node(30);
        // tree.root.right.right.right.left = new Node(16);
        // tree.root.right.right.right.left.right = new Node(10);

        // tree.root.left.left.left = new Node(14);
        // tree.root.left.left.right = new Node(16);
        // tree.root.left.right.left = new Node(19);
        // tree.root.left.right.right = new Node(20);
        // tree.root.left.right.right.left = new Node(7);
        // tree.root.left.right.right.right = new Node(8);

        // tree.root.right.left.left = new Node(15);
        // tree.root.right.left.left.left = new Node(1);
        // tree.root.right.left.left.right = new Node(2);

        // ArrayList<ArrayList<Integer>> answer = tree.nodeToLeafPath(tree.root);

        // for(ArrayList<Integer> i : answer){
        //     for(int val : i){
        //         System.out.print(val + " ");
        //     }
        //     System.out.print("#"+" ");
        // }

        System.out.println(tree.binarySearchTree(tree.root,2));
    }
}
