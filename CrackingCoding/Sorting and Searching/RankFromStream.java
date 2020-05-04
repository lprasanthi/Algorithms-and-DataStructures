class Node {
    public int data;
    public int rank;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        this.rank = 0;
        left = null;
        right = null;
    }

    public void insert(Node cur) {
        if (cur.data < this.data) {
            this.rank++;
            if (this.left == null) {
                this.left = cur;
                return;
            }
            this.left.insert(cur);
            return;
        } else {
            if (this.right == null) {
                this.right = cur;
                return;
            }
            this.right.insert(cur);
        }
    }

    public String toString() {
        return data + " , " + rank;
    }

    public void preOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public int getRank(Node root, int element, int rank){
        if(root == null)
            return -1;
        if(root.data == element){
            return rank+root.rank;
        }
        if(element < root.data){
            return getRank(root.left, element, rank);
        }
        return getRank(root.right, element, root.rank+1); 
    }
    public int getRank(int element){
        return this.getRank(this, element, 0);
    }
}

class Stream {
    Node root;

    Stream() {
        root = null;
    }

    public void add(int number) {
        if (root == null) {
            root = new Node(number);
            return;
        }
        root.insert(new Node(number));
    }

    public int getRank(int element) {
        // root.preOrder(root);
        return root.getRank(element);
        // return -1;
    }

}

public class RankFromStream {
    public static void main(String[] args) {
        int a[] = {20,15,10,18,5,13,16,25,23};
        Stream s = new Stream();
        for(int i=0; i<a.length;i++)
            s.add(a[i]);
        for(int i=0; i< a.length; i++){
            int rank = s.getRank(a[i]);
            System.out.println(a[i]+" , "+rank);
        }
        
    }
}