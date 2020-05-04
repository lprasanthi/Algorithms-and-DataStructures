import java.util.*;
public class SparseSearch{
    private static int getNonEmpty(String[] input, int mid,int low, int high) {
        int left=mid-1;
        int right=mid+1;
        while(true){
            if(left<low && right > high)
                return -1;
            if(left>=low && !"".equals(left)){
                return left;
            }else if(right<=high && !"".equals(right)){
                return right;
            }
            left--;
            right++;
        }
    }
    public static int search(String[] input, int low, int high, String s){
        if(low > high)
            return -1;
        int mid = (low+high)/2;
        if("".equals(input[mid])){
            mid= getNonEmpty(input,mid,low,high);
        }
        if(mid == -1 || input[mid].equals(s))
            return mid;
        else if(s.compareTo(input[mid]) < 0)
            return search(input,low,mid-1,s);
        return search(input,mid+1,high,s);  
    }
    public static int search(String[] input, String s){
        return search(input,0,input.length -1, s);
    }
    public static void main(String[] args) {
        String input[]={"","","","","","","","","","","","","","","dad","",""};
        int index=search(input,"car");
        System.out.println(index);
    }
}