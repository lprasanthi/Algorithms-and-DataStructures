package Tree;
public class TreeNode<T>{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(){
        this.left = null;
        this.right = null; 
    }
    public TreeNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    private void inorder(TreeNode<T> node){
        if(node == null)
            return;
        System.out.println(node.data);
        inorder(node.left);
        inorder(node.right);
    }
    private TreeNode<T> get(TreeNode<T> node, T p){
        if(node == null)
            return node;
        if(node.data == p)
            return node;
        TreeNode<T> left = get(node.left, p);
        if(left == null)
            left = get(node.right, p);
        return left;
    }
    private TreeNode<T> get(TreeNode<T> node, TreeNode<T> p){
        if(node == null || node == p)
            return node;
        TreeNode<T> left = get(node.left, p);
        if(left == null)
            left = get(node.right, p);
        return left;
    }
    public void inorder(){
        inorder(this);
    }
    public TreeNode<T> get(T p){
        return get(this,p);
    }
    public TreeNode<T> get(TreeNode<T> p){
        return get(this,p);
    }
    private TreeNode<T> buildTree(T[] a, int low, int high){
        if(low<0 || low>=a.length || high < 0 || high >= a.length || low>high){
            return null;
        }
        int mid = (low+high)/2;
        if((Integer)a[mid] == Integer.MIN_VALUE){
            return null;
        }
        TreeNode<T> root = new TreeNode<T>(a[mid]);
        root.left = buildTree(a,low,mid-1);
        root.right = buildTree(a,mid+1,high);
        return root;
    }
    
    public TreeNode<T> buildTree(T[] a){
        return buildTree(a,0,a.length-1);
    }
    
    public TreeNode<T> buildTree(T[] a,int i){
        TreeNode<T> root = new TreeNode<T>(a[i]);
        root.left = buildTree(a,0,i-1);
        root.right = buildTree(a,i+1,a.length-1);
        return root;
    }
    public String toString(){
        return this.data+"";
    }
}