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
    Node second;
    int first;
    Pair(){}
    Pair(int vert,Node node){
        this.first = vert;
        this.second = node;
    }

}

public class VerticalViewBinaryTree {
    Node root;
    VerticalViewBinaryTree(){
        this.root = null;
    }
    
    public ArrayList<Integer> verticalTraversal(Node root){

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Pair> que = new LinkedList<Pair>();

        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        que.add(new Pair(0,root));
        int vert_count = 0,mn = 0,mx = 0;

        while(!que.isEmpty()){
            Pair temp = que.poll();

            Node temp_node = temp.second;
            int vertext = temp.first;

            if(!hm.containsKey(vertext)){
                hm.put(vertext,new ArrayList<Integer>());
            }
            
            hm.get(vertext).add(temp_node.data);
            

            if(temp_node.left!=null){
                que.add(new Pair(vert_count-1,temp_node.left));
            }
            if(temp_node.right!=null){
                que.add(new Pair(vert_count+1,temp_node.right));
            }

            if(mx<vert_count){
                mx = vert_count;
            }
            else if(mn>vert_count){
                mn = vert_count;
            }
        }

        for(int i = mn;i<mx+1;i++){
            ArrayList<Integer> list =  hm.get(i);
            for(int j=0;j<list.size();j++){
                ans.add(list.get(j));
            }
        }

        return ans;
    }

    public static void main(String arg[]){
        
        VerticalViewBinaryTree tree = new VerticalViewBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(29);
        tree.root.left.right = new Node(31);
        tree.root.right.left = new Node(56);
        tree.root.right.right = new Node(43);

        tree.root.right.right.right = new Node(30);
        tree.root.right.right.right.left = new Node(16);
        tree.root.right.right.right.left.right = new Node(10);

        tree.root.left.left.left = new Node(14);
        tree.root.left.left.right = new Node(16);
        tree.root.left.right.left = new Node(19);
        tree.root.left.right.right = new Node(20);
        tree.root.left.right.right.left = new Node(7);
        tree.root.left.right.right.right = new Node(8);

        tree.root.right.left.left = new Node(15);
        tree.root.right.left.left.left = new Node(1);
        tree.root.right.left.left.right = new Node(2);

        ArrayList<Integer> answer = tree.verticalTraversal(tree.root);

        for(int i : answer){
            System.out.println(i);
        }
    }
}