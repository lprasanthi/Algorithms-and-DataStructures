import java.util.*;
public class TwoPairsSum{
    public static int[] twoSum(int[] array, int sum){
        Set<Integer> set = new HashSet<Integer>();
        int[] res= new int[2];
        for(int i=0; i< array.length; i++){
            int target = sum-array[i];
            if(set.contains(array[i])){
                res[0]= target;
                res[1]= array[i];
                return res;
            }
            set.add(target);
        }
        return res;
    }
    public static void main(String[] args) {
       int a[] = {-2,-1,0,3,5,6,7,9,13,14};
       int res[] = twoSum(a,8);
       System.out.println(res[0]+" , "+res[1]); 
    }
}