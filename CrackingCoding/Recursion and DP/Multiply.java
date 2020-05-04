public class Multiply{
    private static int mul(int small,int big){
        if(small == 1)
            return big;
        int res= mul(small/2,big);
        if(small%2 == 0) {
           return res+res;
        }
        return res+res+big;
    }
    public static int product(int a, int b) {
        int small = a <= b ? a : b;
        int big = a > b ? a : b;
        return mul(small,big);
    }
    public static void main(String[] args) {
        System.out.println(product(11,4));
    }
}