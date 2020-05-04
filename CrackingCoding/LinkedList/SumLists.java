class LinkedList{
    Node head;
    public LinkedList(){
        head = null;
    }
    public LinkedList(int val){
        head =new Node(val);
    }
    public LinkedList(Node head){
        this.head =head;
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
    public int length(){
        int count = 0;
        Node cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void print(){
        Node cur=head;
        while(cur != null){
            System.out.print(cur.val+" -> ");
            cur = cur.next;
        }
        System.out.println();
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
public class SumLists{
    private static int carry=0;
    // refer to algorithmns for better solution
    
    private static Node forwardSumHelper(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return null;
        }
        Node head = forwardSumHelper(head1.next, head2.next);
        int sum = head1.val + head2.val + carry;
        carry = sum/10;
        int result = sum%10;
        Node cur = new Node(result);
        cur.next = head;
        head = cur;
        return head;
    }
    public static Node forwardSum(LinkedList list1, LinkedList list2){
        if(list1.length() == list2.length()){
            Node head= forwardSumHelper(list1.getHead(),list2.getHead());
            if(carry != 0){
                Node cur = new Node(carry);
                cur.next=head;
                head=cur;
            }
            return head;
        } else {
            //pad with 0's and add 
        }
        return null;
    }
    public static LinkedList reverseSum(LinkedList l1, LinkedList l2){
        int carry = 0;
        Node head= new Node(-1);
        Node result = head;
        Node head1 = l1.getHead(), head2= l2.getHead();
        while(head1 != null || head2!= null){
            int sum = carry;
            if(head1 != null)
                sum+=head1.val;
            if(head2 != null)
                sum+=head2.val;
            carry = sum/10;
            Node temp = new Node(sum%10);
            result.next = temp;
            result = result.next; 
            if(head1 != null)
                head1 = head1.next;
            if(head2 != null)
                head2 = head2.next;
        }
        if(carry != 0){
            result.next = new Node(carry);
            result=result.next;
        }
        result.next = null;
        return new LinkedList(head.next);
    }
    public static void main(String[] args) {
        LinkedList list= new LinkedList(); 
        list.add(1);
        list.add(2);
        list.add(3);
        LinkedList list2= new LinkedList(); 
        list2.add(9);
        list2.add(5);
        list2.add(7);
        Node sum=forwardSum(list,list2);
        while(sum != null){
            sum.print();
            sum = sum.next;
        }
        LinkedList result = reverseSum(list, list2);
        result.print();
    }
}