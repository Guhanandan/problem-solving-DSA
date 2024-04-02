import java.util.*;


class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ZigZagTraversal {
    Node root;
    ZigZagTraversal(){
        this.root = null;
    }
    public ArrayList<Integer> zigZagTraversalBinarytree(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Node> que = new LinkedList<>();

        que.add(root);
        boolean leftToRight = true;
        while(!que.isEmpty()){
            int size = que.size();
            Stack<Integer> st = new Stack<Integer>();
            for(int i=0;i<size;i++){
                Node temp_node = que.poll();
                if(leftToRight){
                    ans.add(temp_node.data);
                }
                else{
                    st.add(temp_node.data);
                }
                if(temp_node.left!=null){
                    que.add(temp_node.left);
                }
                if(temp_node.right!=null){
                    que.add(temp_node.right);
                }
            }
            if(!leftToRight){
                while(!st.isEmpty()){
                    ans.add(st.pop());
                }
            }
            leftToRight = !leftToRight;

        }

        return ans;
    }
    public static void main(String arg[]){
        
        ZigZagTraversal tree = new ZigZagTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(29);
        tree.root.left.right = new Node(31);
        tree.root.right.left = new Node(56);
        tree.root.right.right = new Node(43);

        // tree.root.right.right.right = new Node(30);
        // tree.root.right.right.right.left = new Node(16);
        // tree.root.right.right.right.left.right = new Node(10);

        tree.root.left.left.left = new Node(14);
        tree.root.left.left.right = new Node(16);
        tree.root.left.right.left = new Node(19);
        tree.root.left.right.right = new Node(20);
        // tree.root.left.right.right.left = new Node(7);
        // tree.root.left.right.right.right = new Node(8);

        // tree.root.right.left.left = new Node(15);
        // tree.root.right.left.left.left = new Node(1);
        // tree.root.right.left.left.right = new Node(2);

        ArrayList<Integer> answer = tree.zigZagTraversalBinarytree(tree.root);

        for(int i : answer){
            System.out.println(i);
        }
    }
}
