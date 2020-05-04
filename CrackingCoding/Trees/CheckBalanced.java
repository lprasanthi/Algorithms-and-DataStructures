import java.util.*;
import Tree.*;
public class CheckBalanced{
    private static int height(TreeNode<Integer> root){
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        if(leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        int rightHeight = height(root.right);
        if(rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return Math.max(leftHeight, rightHeight)+1;
    }
    public static boolean isBalanced(TreeNode<Integer> root){
        return height(root)!= Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a);
        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }
}