// https://www.youtube.com/watch?v=CE2b_-XfVDk&t=309s
import java.util.Arrays; 
public class LongestIncreasingSubsequence{
    public static int LISLength(int[] sequence){
        int[] a = new int[sequence.length];
        Arrays.fill(a,1);
        int max=1;
        for(int i=1; i<sequence.length;i++){
            for(int j=0; j<i;j++){
                if(sequence[j] < sequence[i]){
                    a[i] = Math.max(a[j]+1, a[i]);
                }
            }
            max=Math.max(max,a[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]={-13,-7,-9,-10,-1,3,8,-6,3,12,-8,16};
        System.out.println(LISLength(a));
    }
}