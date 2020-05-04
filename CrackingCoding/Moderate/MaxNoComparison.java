public class MaxNoComparison{
    // return 0 for positive, 1 for negative
    private static int sign(int a){
        int signbit = a >> 31;
        int mask = 1;
        return mask & signbit;
    }
    private static int complement(int a){
      return Math.abs(a-1);  
    }
    public static int findMax(int a, int b){
        int diff = a-b;
        int sign = sign(diff);
        return a*complement(sign) + b*sign;
    }
    public static void main(String[] args) {
        int a=-15, b=-5;
        System.out.println(findMax(a,b));

    }
}