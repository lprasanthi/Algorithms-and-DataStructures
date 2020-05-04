import Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
public class BstSequences{
    private static List<Integer> weave(int prefix,List<Integer> list1,List<Integer> list2){
        List<Integer> result = new ArrayList<Integer>();
        result.add(prefix);
        result.addAll(list1);
        result.addAll(list2);
        return result;
    }
    private static List<List<Integer>> sequenceHelper(TreeNode<Integer> root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        \
        if(root == null){
            result.add(new ArrayList<Integer>());
            return result;
        } 
        List<List<Integer>> list1 = sequenceHelper(root.left);
        List<List<Integer>> list2 = sequenceHelper(root.right); 
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(list1.get(i).size() > 0 && list2.get(j).size() > 0 ){
                    result.add(weave(root.data,list1.get(i),list2.get(j)));
                    result.add(weave(root.data,list2.get(j),list1.get(i)));
                }else{
                    result.add(weave(root.data,list1.get(i),list2.get(j)));
                }
            }
        }
        return result;     
    }
    public static List<List<Integer>> getBstSequences(TreeNode<Integer> root){
       return sequenceHelper(root);
    }
    public static void main(String[] args) {
        Integer[] a={1,2,3,4,5,6,7};
        TreeNode<Integer> root = new TreeNode<Integer>().buildTree(a);
        List<List<Integer>> sequences = getBstSequences(root);
        for(int i=0; i<sequences.size();i++){
            System.out.print("Sequence "+i);
            System.out.println(sequences.get(i));
        }
    }
}