public class PeaksAndValleys{
    public static int maxIndex(int[] a, int i, int j, int k){
        int aMax = (i >=0) && (i < a.length) ? a[i] : Integer.MIN_VALUE;
        int bMax = (j >=0) && (j < a.length) ? a[j] : Integer.MIN_VALUE;
        int cMax = (k >=0) && (k < a.length) ? a[k] : Integer.MIN_VALUE;
        int max = Math.max(aMax, Math.max(bMax, cMax));
        if(max == aMax)
            return i;
        else if(max == bMax)
            return j;
        return k;
    }
    public static int[] sort(int[] a){
        for(int i=1; i<a.length; i+=2) {
            int index=maxIndex(a,i-1,i,i+1);
            if(index != i)  {
                int temp=a[index];
                a[index]=a[i];
                a[i]=temp;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int a[]={0,1,4,7,8,9};
        int b[] = sort(a);
        for(int i=0; i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}