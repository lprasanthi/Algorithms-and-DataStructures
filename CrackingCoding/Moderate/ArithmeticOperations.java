import java.lang.ArithmeticException;
public class ArithmeticOperations{
    // -1*a;
    private static int negate(int a){
        int newsign = a > 0 ? -1 : 1;
        int neg =0;
        while(a != 0) {
           neg = neg+newsign ;
           a= a+newsign;
        }
        return neg;
    }
    private static int negateOptimal(int a){
        int newsign = a > 0 ? -1 : 1;
        int neg =0;
        int delta = newsign;
        while(a != 0) {
           boolean diffSign = (a+delta < 0 && a > 0) || (a+delta > 0 && a < 0);
           if(diffSign) {
               delta = newsign;
           }
           neg = neg+delta ;
           a= a+delta;
           delta = delta+delta;
        }
        return neg;
    }
    public static int subtract(int a, int b){
        return a+negateOptimal(b);
    }
    private static int abs(int a){
        if(a<0)
            return negateOptimal(a);
        return a;
    }
    public static int multiply(int a, int b){
        if(a<b)
            return multiply(b,a);
        int sum =0;
        int i = 0;
        while(i != abs(b)){
            sum = sum+a;
            i = i+1;
        }
        if(b < 0)
            return negateOptimal(sum);
        return sum; 
    }
    public static int divide(int a, int b) throws ArithmeticException{
        if(b == 0)
            throw new ArithmeticException("Divide by Zero error");
        int quotient = 0;
        int absa = abs(a);
        int absb = abs(b);
        int rem = subtract(absa,absb);
        while(rem >= 0){
            quotient = quotient + 1;
            rem = subtract(rem,absb);
        }
        if((a<0 && b> 0) || (a>0 && b<0) )
            return negateOptimal(quotient);
        return quotient;
    }
    public static void main(String[] args) {
        int a= 15, b= -5;
        System.out.println(subtract(a,b));
        System.out.println(multiply(a,b));
        System.out.println(divide(a,b));

    }
}