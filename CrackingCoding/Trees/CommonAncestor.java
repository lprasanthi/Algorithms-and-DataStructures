import Tree.TreeNode;
public class CommonAncestor{
    public static TreeNode<Integer> ancestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q){
        if(root == null || root == p || root == q)
            return root;
        TreeNode<Integer> left = ancestor(root.left,p,q);
        TreeNode<Integer> right = ancestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a);
        TreeNode<Integer> p = root.get(2);
        TreeNode<Integer> q = root.get(1);
        TreeNode<Integer> node = ancestor(root,p,q);
        System.out.println(node.data);
    }
}