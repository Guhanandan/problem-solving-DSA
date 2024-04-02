import java.util.ArrayList;
import java.util.Arrays;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DepthOfBinaryTree {
    Node root;
    DepthOfBinaryTree(){
        this.root = null;
    }

    Node getLCA(Node root,int n1,int n2){
        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }
        Node left = getLCA(root.left, n1, n2);
        Node right = getLCA(root.right, n1, n2);
        if(left!=null && right!=null){
            return root;
        }
        if(left==null && right==null){
            return left;
        }
        else if(left==null){
            return right;
        } 
        else if(right==null){
            return left;
        }
        return null;
    }

    int getSum(ArrayList<Integer> l){
        int ans = 0;
        for(int i=0;i<l.size();i++){
            ans = l.get(i)+ans;
        }
        return ans;
    }
    int recursiveDepth(Node node,int x,int ans[],ArrayList<Integer> list){
        if(node==null){
            return 0;
        }
        if(node.data==x){
            ans[0] = getSum(list);
        }
        list.add(1);
        int left = recursiveDepth(node.left, x,ans,new ArrayList<>(list));
        //list.add(1);
        int right = recursiveDepth(node.right, x,ans,new ArrayList<>(list));
        
        return 1+Math.max(left,right);
    }
    public int findDist(Node node,int x){
        int ans[] = new int[1];
        recursiveDepth(node,x,ans,new ArrayList<>());
        return ans[0];
    }
    int nodeToNodeDist(Node root,int n1,int n2){
        Node lca = getLCA(root, n1, n2);
        int dist = findDist(root, n1)+findDist(root, n2)-2*findDist(root, lca.data);
        return dist;
    }
    public static void main(String arg[]){
        
        DepthOfBinaryTree tree = new DepthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(29);
        tree.root.left.right = new Node(31);
        tree.root.right.left = new Node(56);
        tree.root.right.right = new Node(43);

        tree.root.right.right.right = new Node(30);
        tree.root.right.right.right.left = new Node(17);
        tree.root.right.right.right.right = new Node(10);

        tree.root.left.left.left = new Node(14);
        tree.root.left.left.right = new Node(16);
        tree.root.left.right.left = new Node(19);
        tree.root.left.right.right = new Node(20);

        // tree.root.left.right.right.left = new Node(7);
        // tree.root.left.right.right.right = new Node(8);

        // tree.root.right.left.left = new Node(15);
        // tree.root.right.left.left.left = new Node(1);
        // tree.root.right.left.left.right = new Node(2);
        //System.out.println(tree.findDist(null, 0));
        //System.out.println();
        System.out.println(tree.nodeToNodeDist(tree.root,1,1));

        // for(int i : answer){
        //     System.out.println(i);
        // }
    }
}
