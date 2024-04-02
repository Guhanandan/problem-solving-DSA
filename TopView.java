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

class Pair{
    Node first;
    int second;
    
    Pair(Node node,int vert){
        this.first = node;
        this.second = vert;
    }
}

class TopView {
    Node root;
    TopView(){
        this.root = null;
    }
    
    public ArrayList<Integer> topViewTraversal(Node root){

        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<Pair> que = new LinkedList<>();
        HashMap<Integer,Node> mp = new HashMap<>();
        
        que.add(new Pair(root,0));
        int vertext = 0,mn = 0,mx = 0;

        while(!que.isEmpty()){
            Pair temp_pair = que.poll();
            Node temp_node = temp_pair.first;
            vertext = temp_pair.second;

            if(!mp.containsKey(vertext)){
                mp.put(vertext,temp_node);
            }

            if(temp_node.left!=null){
                que.add(new Pair(temp_node.left,vertext-1));
            }
            if(temp_node.right!=null){
                que.add(new Pair(temp_node.right,vertext+1));
            }
            
            if(mx<vertext){
                mx = vertext;
            }
            else if(mn>vertext){
                mn = vertext;
            }
        }
        for(int i = mn;i<=mx;i++){
            Node ans_node = mp.get(i);
            ans.add(ans_node.data);
        }

        return ans;
    }

    int sumTree(Node root){
        if(root==null){
            return 0;
        }
        return root.data + sumTree(root.left) + sumTree(root.right);
    }

    public static void main(String arg[]){
        
        TopView tree = new TopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(9);

        int ans = tree.sumTree(tree.root);
        System.out.println(ans);

        // tree.root.left.left.left = new Node(14);
        // tree.root.left.left.right = new Node(16);
        // tree.root.left.right.left = new Node(19);
        // tree.root.left.right.right = new Node(20);

        // tree.root.right.right.right = new Node(30);
        // tree.root.right.right.right.left = new Node(16);
        // tree.root.right.right.right.left.right = new Node(10);

        
        // tree.root.left.left.left.left = new Node(13);
        // tree.root.left.left.left.left.left = new Node(12);
        // tree.root.right.right.right = new Node(44);
        // tree.root.right.right.right.right = new Node(45);
        // tree.root.left.right.right.left = new Node(7);
        // tree.root.left.right.right.right = new Node(8);

        // tree.root.right.left.left = new Node(15);
        // tree.root.right.left.left.left = new Node(1);
        // tree.root.right.left.left.right = new Node(2);

        // ArrayList<Integer> answer = tree.topViewTraversal(tree.root);

        // for(int i : answer){
        //     System.out.println(i);
        // }
    }
}