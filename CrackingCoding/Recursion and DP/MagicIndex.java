public class MagicIndex{
    private static int findDistinctHelper(int[] a,int start,int end){
        if(start > end || start>a.length-1 || end < 0){
            return -1;
        }
        int mid = (start+end)/2;
        if(a[mid] == mid)
            return mid;
        else if(a[mid] < mid) {
            return findDistinctHelper(a,mid+1,end);
        }
        return findDistinctHelper(a,start,mid-1);
    }
    public static int findDistinct(int[] a){
        return findDistinctHelper(a,0,a.length-1);
    }
    private static int find(int[] a,int start, int end){
        if(start > end || start>a.length-1 || end < 0){
            return -1;
        }
        int mid = (start+end)/2;
        if(a[mid] == mid)
            return mid;
        else if(a[mid] < mid){
            int temp = find(a,0,a[mid]);
            if( temp == -1)
                return find(a,mid+1,end);
            return temp;
        }
        int temp = find(a,a[mid],end);
        if( temp == -1)
            return find(a,start,mid-1);
        return temp;

    }
    public static int find(int[] a){
        return find(a,0,a.length-1);
    }
    public static void main(String[] args) {
        int a[] = {-40,-20,-1,2,3,4,6,8,12,13};
        int b[] = {-10,-5,2,2,2,3,4,5,9,12,13};
        System.out.println(findDistinct(a));
        System.out.println(find(b));
    }
}