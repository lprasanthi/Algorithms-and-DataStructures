class Node{
    public int data;
    public Node left;
    public Node right;
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class List{
    public Node head;
    public Node tail;
    public List(Node head, Node tail){
        this.head = head;
        this.tail = tail;
    }
    public String toString(){
        String text=""; 
        if(head == null){
            text = text+"null";
        }else{
            text = text+head.data;
        }
        if(tail == null){
            text = text+", null";
        }else{
            text = text+", "+tail.data;
        }
        return text;
    }
}
public class BiNode {
    private static void link(Node prev, Node next){
        if(next != null)
            next.left = prev;
        if(prev != null)
            prev.right = next;
    }
    public static List convert(Node root){
        if(root == null){
            return new List(null, null);
        }
        List left = convert(root.left);
        List right = convert(root.right);
        Node newHead = root;
        Node newTail = root;
        if(left != null){
            link(left.tail, root);
            newHead = left.head != null ? left.head : root;
        }
        if(right != null){
            link(root, right.head);
            newTail = right.tail != null ? right.tail : root;
        }
        return new List(newHead,newTail);
    }
    public static Node treeToList(Node root){
        return convert(root).head;
    }
    public static Node BST(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        four.left = two;
        two.left = one;
        two.right = three;
        four.right = six;
        six.left = five;
        six.right = seven;
        seven.right = eight;
        return four;
    }
    public static void main(String[] args) {
        Node root = BST();
        Node head = treeToList(root);
        while(head != null){
            System.out.println(head.data);
            head=head.right;
        }
    }
}