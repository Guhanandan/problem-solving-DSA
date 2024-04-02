
public class LinkedList {
    class Node{
        Node next;
        int data;
        Node(int item){
            this.data = item;
            this.next = null;
        }
    }
    
    Node head;
    LinkedList(){
        head = null;
    }
    public void insert(int x){
        if(head == null){
            head = new Node(x);
        }
        else{
            Node temp = head;
            Node new_node = new Node(x);
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new_node;
        }
    }
    public void reverseList(Node head){
        Node temp = head;
        Node nex = null;
        Node prev = null;

        while(temp.next!=null){
            nex = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nex;
        }
        temp.next = prev;
        temp = head;
    }

    public Node findKthNode(Node head,int k){
        Node temp = head;
        while(temp.next!=null && k>1){
            k--;
            temp = temp.next;
        }
        // if(temp==null){

        // }
        return temp;
    }

    public Node reverseInGroup(Node head,int k){
        if(head==null){
            return head;
        }
        Node temp = head,next = null,prev = null;
        while(temp!=null){
            Node kthNode = findKthNode(temp,k);
            next = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if(temp==head){
                head = kthNode;
                prev = temp;
                temp.next = next;
                temp = next;
            }
            else{
                prev.next = kthNode;
                prev = temp;
                temp.next = next;
                temp = next;
            }
        }
        return head;
    }

    public void printList(Node head){
        if(head==null){
            System.out.println("Head is null");
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] arg){
        LinkedList list = new LinkedList();
        list.insert(8);
        list.insert(4);
        list.insert(9);
        list.insert(10);
        list.insert(6);
        list.insert(3);
        list.insert(19);
        list.insert(13);
        list.insert(16);
        list.insert(23);

        Node ans = list.reverseInGroup(list.head,4);
        list.printList(ans);
    }
}
