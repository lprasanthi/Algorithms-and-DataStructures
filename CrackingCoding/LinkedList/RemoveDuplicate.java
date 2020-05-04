import java.util.*;
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
}
public class RemoveDuplicate{
    public static void removeDupBuffer(LinkedList list){
        Node head = list.getHead();
        Node cur = head, prev=null;
        Set<String> hashset = new HashSet<String>();
        while(cur != null){
            if(hashset.contains(cur.val)){
                prev.next = cur.next;
            }else{
                hashset.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
    }
    public static void removeDupNoBuffer(LinkedList list){
        Node head = list.getHead();
        Node cur = head;
        while(cur != null){
            Node runner = cur;
            while(runner.next != null){
                if(runner.next.val == cur.val){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            cur = cur.next;
        }
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
       removeDupNoBuffer(list);
       list.print();
    }
}