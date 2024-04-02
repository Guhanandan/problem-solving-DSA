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

public class BinarySearchtree {
    Node root;
    BinarySearchtree(){
        root = null;
    }
    Node insertRec(Node root,int x){
        if(root==null){
            root = new Node(x);
            return root;
        }

        if(root.data>x){
            root.left = insertRec(root.left,x);
        }
        else{
            root.right = insertRec(root.right,x);
        }
        return root;
    }

    ArrayList<Integer> printPreorder(Node root,ArrayList<Integer> ans){
        if(root==null){
            return ans;
        }
        ans.add(root.data);
        ans = printPreorder(root.left,ans);
        ans = printPreorder(root.right,ans);
        return ans;
    }
    void insert(int x){
        root = insertRec(root,x);
    }

    public static void main(String arg[]){
        
        BinarySearchtree tree = new BinarySearchtree();
        //tree.root = null;
        
        tree.insert(30);
        tree.insert(10);
        tree.insert(27);
        tree.insert(35);
        tree.insert(5);
        
        tree.insert(15);
        tree.insert(25);
        

        ArrayList<Integer>  ans = tree.printPreorder(tree.root,new ArrayList<Integer>());

        for(int i : ans){
            System.out.println(i);
        }
    }
}
