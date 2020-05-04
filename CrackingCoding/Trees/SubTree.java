import Tree.TreeNode;
public class SubTree{
    private static boolean match(TreeNode<Integer> p, TreeNode<Integer> q){
        if(p==null && q==null)
            return true;
        if(p==null || q == null)
            return false;
        if(p != q)
            return false;
        return match(p.left,q.left) && match(p.right,q.right);
        
    }
    public static boolean isSubTree(TreeNode<Integer> root, TreeNode<Integer> subRoot){
        if(subRoot == null)
            return true;
        else if(root == null)
            return false;
        TreeNode<Integer> subTree = root.get(subRoot);
        return match(subTree, subRoot);
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a);
        TreeNode<Integer> p = root.get(2);
        boolean subtree= isSubTree(root,p);
        Integer[] b={5,6,7};
        TreeNode<Integer> q = new TreeNode<Integer>().buildTree(b);
        boolean subtree2= isSubTree(root,q);
        System.out.println(subtree2);
    }
}