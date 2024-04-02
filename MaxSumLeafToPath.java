import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class MaxSumLeafToPath {
    Node root;
    MaxSumLeafToPath(){
        this.root = null;
    }
    
    public Node findTargetNode(Node node , int x){
        if(node==null){
            return null;
        }
        if(node.data == x){
            return node;
        }
        Node left = findTargetNode(node.left, x);
        Node right = findTargetNode(node.right, x);
        if(left==null && right==null){
            return null;
        }
        else if(left==null){
            return right;
        }
        else{
            return left;
        }
    }

    public int minTime(Node root, int target) 
    {
        int time=0;
        Node targetNode = findTargetNode(root,target);
        HashMap<Integer,Node> hm = new HashMap<>();
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while(!que.isEmpty()){
            Node temp = que.poll();
            if(temp.left!=null){
                hm.put(temp.left.data,temp);
                que.add(temp.left);
            }
            if(temp.right!=null){
                hm.put(temp.right.data,temp);
                que.add(temp.right);
            }
        }

        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(targetNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Node tempNode = queue.poll();
                if(tempNode.left!=null && !visited.contains(tempNode.left.data)){
                    queue.add(tempNode.left);
                }
                if(tempNode.right!=null && !visited.contains(tempNode.right.data)){
                    queue.add(tempNode.right);
                }
                if(hm.containsKey(tempNode.data) && !visited.contains(hm.get(tempNode.data).data)){
                    queue.add(hm.get(tempNode.data));
                }
                visited.add(tempNode.data);
            }
            time++;
        }
        return time-1;
    }

    public static void main(String arg[]){
        
        MaxSumLeafToPath tree = new MaxSumLeafToPath();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.right.left = new Node(10);
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);
        // tree.root.right.right = new Node(6);
        // tree.root.left.right.left = new Node(7);
        // tree.root.left.right.right = new Node(8);
        // tree.root.right.right.right = new Node(9);
        // tree.root.right.right.right.right = new Node(10);
        System.out.println(tree.minTime(tree.root,10));
    }
}


