public class MergeSorted{
    public static void merge(int[] a, int[] b, int n){
        int length = n+b.length;
        int indexA = n-1;
        int indexB = b.length -1;
        int index= length-1;
        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] >= b[indexB]){
                a[index--] = a[indexA--];
            } else{
                a[index--] = b[indexB--];
            }
        }
    }
    public static void main(String[] args) {
        int[] a= new int[100];
        int n = 5;
        for(int i=1; i<=n; i++){
            a[i-1] = i*2+1;
        }
        int b[]={2,4,6};
        merge(a,b,n);
        for(int i=0; i<n+b.length; i++){
            System.out.println(a[i]);
        }
    }
}