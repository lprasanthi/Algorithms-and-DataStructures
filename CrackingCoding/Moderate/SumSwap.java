import java.util.*;
public class SumSwap{
    private static int sum(int[] a){
        int sum=0;
        for(int i=0; i<a.length;i++){
            sum = sum+a[i];
        }
        return sum;
    }
    public static int[] findSwapValues(int[] a, int[] b){
        int sumA=sum(a);
        int sumB=sum(b);
        System.out.println(sumA+" "+sumB);
        if(sumA > sumB)
            return findSwapValues(b,a);
        Set<Integer> set = new HashSet<Integer>();
        int[] result = new int[2];
        for(int i=0; i<b.length; i++){
            set.add(b[i]);
        }
        for(int i=0; i<a.length;i++){
            int val = ((sumB+a[i])-(sumA-a[i]))/2;
            if(set.contains(val)){
                result[0] = a[i];
                result[1] = val;
                return result;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int a[] = {4,1,2,1,1,2};
        int b[] = {3,6,3,3};
        int[] sum= findSwapValues(a,b);
        System.out.println(sum[0]+", "+sum[1]);
    }
}