import Tree.TreeNode;
public class PathsWithSum{
    public static void main(String[] args) {
        Integer[] a={3,3,-2,5,Integer.MIN_VALUE,2,1,10,Integer.MIN_VALUE,-3,11};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a,7);
        root.inorder();
    }
}