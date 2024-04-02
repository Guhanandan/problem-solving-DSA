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

class BinaryTree{
    Node root;
    BinaryTree(){
        this.root = null;
    }

    public void printLevelOrder(){

        ArrayList<Node> que = new ArrayList<>();
        que.add(root);

        while(que.size()!=0){
            Node temp = que.remove(0);
            if(temp.left!=null){
                que.add(temp.left);
            }
            if(temp.right!=null){
                que.add(temp.right);
            }
            System.out.print(temp.data + " ");
        }
    }

    public boolean isLeaf(Node node){
        if(node.left==null && node.right==null){
            return true;
        }
        else{
            return false;
        }
    }

    public void printLeaf(Node root){
        if(isLeaf(root)){
            System.out.print(root.data+" ");
            return;
        }
        printLeaf(root.left);
        printLeaf(root.right);
    }

    public void printLeafs(){
        printLeaf(root);
    }

    public static void main(String arg[]){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(24);
        tree.root.right = new Node(36);

        tree.root.left.left = new Node(29);
        tree.root.left.right = new Node(31);
        tree.root.right.left = new Node(56);
        tree.root.right.right = new Node(43);

        tree.root.left.left.left = new Node(14);
        tree.root.left.left.right = new Node(16);
        tree.root.left.right.left = new Node(19);
        tree.root.left.right.right = new Node(20);
        tree.root.left.right.right.left = new Node(7);
        tree.root.left.right.right.right = new Node(8);


        tree.printLevelOrder();
        System.out.println();
        tree.printLeafs();
    }
}