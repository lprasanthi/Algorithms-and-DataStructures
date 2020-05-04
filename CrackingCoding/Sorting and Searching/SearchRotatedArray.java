public class SearchRotatedArray{
    public static int search(int[] a, int low,int high, int n){
        if(high<low)
            return -1;
        int mid=(low+high)/2;
        if(a[mid] == n)
            return mid;
        if(a[low] < a[mid]) {
            //low is ordered
            if(n < a[mid] && n > a[low])
                return search(a,low,mid-1,n);
            return search(a,mid+1,high,n);
        }else if(a[low] > a[mid]){
            //high is ordered
            if(n > a[mid] && n<a[high])
                return search(a,mid+1,high,n);
            return search(a,low,mid-1,n);
        }else{
            if(a[high] == a[mid]){
                //search both halves
                int found = search(a,low,mid-1,n);
                if(found < 0)
                    return search(a,mid+1,high,n);
                return found;
            }else{
                //high is ordered
                return search(a,mid+1,high,n);  
            }
        }
    }
    public static int search(int[] a, int n){
        return search(a,0,a.length-1,n);
    }
    public static void main(String[] args) {
        int a[]={4,2,2,2,3,4,4};
        int index=search(a,2);
        System.out.println(index);
    }
}