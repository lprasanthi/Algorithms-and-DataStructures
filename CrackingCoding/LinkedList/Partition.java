class LinkedList{
    Node head;
    public LinkedList(){
        head = null;
    }
    public LinkedList(int val){
        head =new Node(val);
    }
    public void add(int val){
        if(head == null){
            head = new Node(val);
            return;
        }
        Node cur= head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next= new Node(val);
    }
    public Node getHead(){
        return head;
    }
    public void print(){
        Node cur=head;
        while(cur != null){
            System.out.print(cur.val+" -> ");
            cur = cur.next;
        }
    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next=null;
    }
    public void print(){
        System.out.println(this.val);
    }
}
public class Partition{
    private static Node PartitionAroundX(LinkedList list, int k){
        Node head = list.getHead();
        Node tail=head;
        Node cur=head;
        while(cur != null){
            Node temp = cur.next;
            if(cur.val < k){
                cur.next = head;
                head = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            cur = temp;
        }
        tail.next=null;
        return head;
    }
    public static void main(String[] args) {
        LinkedList list= new LinkedList(); 
       list.add(3);
       list.add(5);
       list.add(8);
       list.add(5);
       list.add(10);
       list.add(2);
       list.add(1);
       list.add(9);
       Node head = PartitionAroundX(list, 8);
       while(head != null){
            head.print();
            head = head.next;
       }
    }
}