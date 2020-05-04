public class RepresentCoins{
    private static int findMaxCoins(int amount, int cents){
        return amount/cents;
    }
    public static int makeChange(int amount, int[] denom, int pos){
        if(amount ==0 || pos >= denom.length -1)
            return 1;
        int count=0;
        int currentDenom = denom[pos];
        int highest = findMaxCoins(amount, currentDenom);
        for(int j=highest; j>=0; j--) {
            int remaining = amount - j*(currentDenom);
            count = count + makeChange(remaining,denom,pos+1);
        }
        return count;
    }
    public static int makeChange(int num, int[] changeAvailable){
        int i=0;
        while(i<changeAvailable.length && num < changeAvailable[i]){
            i++;
        }
        if(i == changeAvailable.length)
            return -1;
        return makeChange(num,changeAvailable,i);
    }
    public static void main(String[] args) {
        int changeAvailable[] = {25,10,5,1};
        int num = 100;
        int ways = makeChange(num,changeAvailable);
        System.out.println(ways);
    }
}