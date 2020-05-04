
public class CountWays{
    public static int ways(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        return ways(n-1)+ways(n-2)+ways(n-3);
    }
    private static int waysMemoHelper(int n, int[] map){
        if(n<0){
            return 0;
        }
        if(map[n]==0)
            map[n] = ways(n-1)+ways(n-2)+ways(n-3);
        return map[n];
    }
    public static int waysMemo(int n){
        // Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] map = new int[n+1];
        for(int i=0;i<=n;i++)
            map[i] = 0;
        map[0] = 1;
        return waysMemoHelper(n,map);
    }
    public static int waysIteration(int n){
        int a=0, b=1,c=1;
        int sum=0;
        for(int i=1; i<n;i++){
            sum = a+b+c;
            a=b;
            b=c;
            c=sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(waysIteration(10));
        System.out.println(ways(10));
        System.out.println(waysMemo(10));
    }
}