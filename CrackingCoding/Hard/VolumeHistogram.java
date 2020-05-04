public class VolumeHistogram{
    public static int volume(int[] a){
        int[] max_so_far = new int[a.length];
        int[] max_from_last = new int[a.length];
        int max=a[0];
        int sum = 0;
        for(int i=0; i<a.length;i++){
            max=Math.max(max,a[i]);
            max_so_far[i] = max;
        }
        max=a[a.length-1];
        for(int i=a.length-1; i>=0;i--){
            max=Math.max(max,a[i]);
            int min = Math.min(max_so_far[i], max);
            sum = sum + (min - a[i]);
        }

        return sum;
    }
    public static void main(String[] args) {
        int a[]={0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};
        System.out.println(volume(a));
    }
}