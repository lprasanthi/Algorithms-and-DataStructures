import java.util.*;
import Tree.*;
public class ValidateBST{
    private static boolean isBSTHelper(TreeNode<Integer> root, Integer left, Integer right){
        if(root == null){
            return true;
        }
        if(root.data< left || root.data > right)
            return false;
        return isBSTHelper(root.left, left ,root.data) && isBSTHelper(root.right,root.data,right);
    }
    public static boolean isBST(TreeNode<Integer> root){
        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7,};
        Integer[] b={9,5,3,7,6,2,1};
        TreeNode<Integer> root1 = new TreeNode<Integer>().buildTree(a);
        TreeNode<Integer> root2 = new TreeNode<Integer>().buildTree(b);
        boolean bst1 = isBST(root1);
        System.out.println(bst1);
        boolean bst2 = isBST(root2);
        System.out.println(bst2);
    }
}