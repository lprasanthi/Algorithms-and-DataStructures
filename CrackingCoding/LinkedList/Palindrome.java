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

public class Palindrome{
    private static boolean isPalindromeHelper(Node first, Node second){
        while(second != null){
            if(second.val != first.val){
                return false;
            }
            second=second.next;
            first=first.next;
        }
        return true;
    }
    public static boolean isPalindrome(LinkedList list){
        Node head = list.getHead();
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }
        Node tail = slow;
        if(fast != null){
            slow = slow.next;
        }
        System.out.println("tail "+tail.val+" slow "+slow.val);
        Node cur = head;
        while(cur != tail){
            Node temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        return isPalindromeHelper(head,slow);
    }
    public static void main(String[] args) {
      LinkedList list= new LinkedList(); 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        // list.add(1);
        System.out.println(isPalindrome(list));

    }
}