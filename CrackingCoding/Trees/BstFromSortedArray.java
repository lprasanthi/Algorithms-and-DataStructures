import Tree.TreeNode;
public class BstFromSortedArray{
    private static TreeNode<Integer> buildBstHelper(int[] a, int low, int high){
        if(low<0 || low>=a.length || high < 0 || high >= a.length || low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode<Integer> root = new TreeNode<Integer>(a[mid]);
        root.left = buildBstHelper(a,low,mid-1);
        root.right = buildBstHelper(a,mid+1,high);
        return root;
    }
    public static TreeNode<Integer> buildBst(int[] a){
        return buildBstHelper(a,0,a.length-1);
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        TreeNode<Integer> root= buildBst(a);
        root.inorder();
    }
}