public class FactorialZeros{
    public static int countZeros(int n){
        int count =0;
        for(int i=5; n/i > 0; i*=5){
            count = count + (n/i);
        }
        return count;
    }
    public static void main(String[] args) {
        int n= 125;
        System.out.println(countZeros(n));
    }
}