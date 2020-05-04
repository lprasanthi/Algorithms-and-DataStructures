import java.util.*;
import Tree.*;
public class ListOfDepths{
    private static void DfsLevelLists(TreeNode<Integer> root,List<List<TreeNode<Integer>>> list, int count){
        if(root == null){
           return;
        }
        List<TreeNode<Integer>> depthList;
        if(list.size() > count){
            depthList = list.get(count);
        }else {
            depthList = new LinkedList<>();
            list.add(depthList);
        }
        depthList.add(root);
        DfsLevelLists(root.left, list, count+1);
        DfsLevelLists(root.right, list, count+1);
    }
    public static List<List<TreeNode<Integer>>> createLevelLinkedLists(TreeNode<Integer> root){
        List<List<TreeNode<Integer>>> lists = new ArrayList<List<TreeNode<Integer>>>();
        DfsLevelLists(root,lists,0);
        return lists;
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a);
        List<List<TreeNode<Integer>>> lists = createLevelLinkedLists(root);
        System.out.println(lists);
    }
}