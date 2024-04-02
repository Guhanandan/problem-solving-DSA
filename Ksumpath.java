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

public class Ksumpath {
    Node root;
    Ksumpath(){
        root = null;
    }

    public int findPath(ArrayList<Integer> list,int k){
        int sum = 0;
        for(int i=list.size()-1;i>=0;i--){
            sum+=list.get(i);
            if(sum==k){
                return 1;
            }
            if(sum>k){
                return 0;
            }
        }
        return 0;
    }
    public void kSumPath(Node root,int k,int ans[],ArrayList<Integer> list){
        if(root==null){
            return ;
        }

        list.add(root.data);
        kSumPath(root.left, k, ans, new ArrayList<>(list));
        kSumPath(root.right, k, ans, new ArrayList<>(list));

        ans[0] = ans[0] + findPath(list,k);
    }

    public static void main(String arg[]){
        
        Ksumpath tree = new Ksumpath();
        tree.root = new Node(8);
        tree.root.left = new Node(2);
        tree.root.right = new Node(4);

        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);

        tree.root.right.left.left = new Node(3);

        // tree.root.right.right.right = new Node(30);
        // tree.root.right.right.right.left = new Node(17);
        // tree.root.right.right.right.right = new Node(10);

        // tree.root.left.left.left = new Node(14);
        // tree.root.left.left.right = new Node(16);
        // tree.root.left.right.left = new Node(19);
        // tree.root.left.right.right = new Node(20);
        int ans[] = new int[1];
        tree.kSumPath(tree.root, 8, ans, new ArrayList<>());
        System.out.println(ans[0]);
    }
}
