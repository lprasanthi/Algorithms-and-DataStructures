class LinkedList{
    Node head;
    public LinkedList(){
        head = null;
    }
    public LinkedList(String val){
        head =new Node(val);
    }
    public void add(String val){
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
    String val;
    Node next;
    public Node(String val){
        this.val = val;
        this.next=null;
    }
    public void print(){
        System.out.println(this.val);
    }
}
public class KToLast{
    public static Node getKToLast(LinkedList list, int k){
        Node head = list.getHead();
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while(p2!= null && count < k){
            p2 = p2.next;
            count++;
        }
        while(p2 != null){
            p2 = p2.next;
            p1=p1.next;
        }
        return p1;
    }
    public static void main(String[] args) {
        LinkedList list= new LinkedList(); 
       list.add("H");
       list.add("E");
       list.add("L");
       list.add("O");
       list.add("L");
       list.add("L");
       list.add("L");
       list.add("L");
       Node k = getKToLast(list, 1);
       k.print();
    }
}