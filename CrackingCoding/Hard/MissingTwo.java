import java.math.*;
public class MissingTwo{
    private static int sumMissing(int[] array, int n){
        int sum =0;
        for(int i=0;i<array.length;i++){
            sum = sum+array[i];
        }
        int sumN = n * (n+1)/2;
        return sumN - sum;
    }
    private static BigInteger factorial(int n){
        BigInteger product = new BigInteger("1");
        for(int i=2; i<=n; i++){
            product = product.multiply(new BigInteger(i+""));
        }
        return product;
    }
    private static int productMissing(int[] array){
        BigInteger product = new BigInteger("1");
        for(int i=0; i<array.length; i++){
            product = product.multiply(new BigInteger(array[i]+""));
        }
        BigInteger missingProduct= factorial(array.length+2).divide(product);
        return Integer.parseInt(missingProduct.toString());
    }
    
    public static int[] missing2(int[] array){
        int product = productMissing(array);
        int sum = sumMissing(array, array.length+2);
        int result[] = new int[2];
        // x+y = sum; xy=product ---> x(sum-x) = product --> x square - sumx + product = 0
        // To solve x and y in a quadratic equation:
        // x and y are : (-b + root(b square - 4ac))/2a and (-b - root(b square - 4ac))/2a
        // a = 1, b= -sum, c= product (x square + ax + b = 0)
        
        int a = 1;
        int b = -sum;
        int c = product;

        double add = -1 * b;
        double deno = 2*a;
        double root = Math.sqrt((b*b)-(4*a*c));
        
        result[0] = (int)((add-root)/deno);
        result[1] = (int)((add+root)/deno);
        return result;
    }
    public static int missingOne(int[] array){
        return sumMissing(array, array.length+1);
    }
    public static void main(String[] args) {
        int a[]={1,2,3,5,6,7};
        int missing = missingOne(a);
        System.out.println(missing);
        int b[]={1,2,3,6,7};
        int missings[] = missing2(b);
        System.out.println(missings[0]+", "+missings[1]);
    }
}