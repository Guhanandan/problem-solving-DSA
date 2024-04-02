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


class BoundaryTravesal{
    Node root;
    BoundaryTravesal(){
        this.root = null;
    }

    public void insert(int x, int y) {
        root = insertRec(root, x, y);
    }

    private Node insertRec(Node root, int x, int y) {
        if (root == null) {
            return new Node(x);
        }

        if (x < root.data) {
            root.left = insertRec(root.left, x, y);
        } else {
            root.right = insertRec(root.right, x, y);
        }

        return root;
    }

    public void addLeft(ArrayList<Integer> list){
        Node temp = root;

        while(temp.left!=null && !isLeaf(temp.left) || temp.right!=null && !isLeaf(temp.right)){
            if(temp.left!=null && isLeaf(temp.left)){
                break;
            }
            if(temp.left!=null && !isLeaf(temp.left)){
                list.add(temp.data);
                temp = temp.left;
            }
            else if(temp.right!=null && !isLeaf(temp.right)){
                list.add(temp.data);
                temp = temp.right;
            }
        }
        list.add(temp.data);
    }

    public void addLeaf(Node root,ArrayList<Integer> list){
        if(root!=null && isLeaf(root)){
            list.add(root.data);
            return;
        }
        if(root.left!=null)
            addLeaf(root.left,list);
        if(root.right!=null)
            addLeaf(root.right,list);
    }

    public void addLeafs(ArrayList<Integer> list){
        addLeaf(root,list);
    }

    public void addRight(ArrayList<Integer> list){
        Stack<Integer> st = new Stack<>();
        Node temp = root.right;
        while(temp.right!=null && !isLeaf(temp.right) || temp.left!=null && !isLeaf(temp.left)){
            if(temp.right!=null && isLeaf(temp.right)){
                break;
            }
            if(temp.right!=null && !isLeaf(temp.right)){
                st.push(temp.data);
                temp = temp.right;
            }
            else if(temp.left!=null && !isLeaf(temp.left)){
                st.push(temp.data);
                temp = temp.left;
            }
        }
        if(!isLeaf(temp))
            st.push(temp.data);

        while(st.size()>0){
            list.add(st.pop());
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

    public ArrayList<Integer> arrayListAns(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(isLeaf(root)){
            list.add(root.data);
            return list;
        }

        addLeft(list);
        addLeafs(list);
        addRight(list);
        return list;
    }

    public static void main(String arg[]){
        
        // BoundaryTravesal tree = new BoundaryTravesal();
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);

        // tree.root.left.left = new Node(29);
        // tree.root.left.right = new Node(31);
        // tree.root.right.left = new Node(56);
        // tree.root.right.right = new Node(43);

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

        BoundaryTravesal tree = new BoundaryTravesal();
        int[] coordinates = {4, 10, 5, 5, 6, 7, 8, 8, 8, 11, 3, 4, 1, 3, 8, 6, 11, 11, 5, 8};

        for (int i = 0; i < coordinates.length; i += 2) {
            int x = coordinates[i];
            int y = coordinates[i + 1];
            tree.insert(x, y);
        }

        ArrayList<Integer> ans = tree.arrayListAns(tree.root);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}