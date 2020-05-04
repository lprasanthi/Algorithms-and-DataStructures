import java.util.Arrays;
public class SmallestDifference{
    public static int minDiff(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int min = Math.abs(a[0]-b[0]);
        int i=0,j=0;
        while(i<a.length && j< b.length) {
            if(a[i] <= b[j]){
                min = Math.min(min, (b[j]-a[i]));
                i++;
            }else{
                min = Math.min(min, (a[i]-b[j]));
                j++;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int a[]={1,3,15,11,2};
        int b[]={23,127,235,19,8};
        int diff = minDiff(a,b);
        System.out.println(diff);
    }
}