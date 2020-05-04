public class Swap{
    public static int[] swapNoTemp(int a, int b){
        a=a+b;
        b=a-b;
        a=a-b;
        int swapped[] = {a,b};
        return swapped;
    }
    public static void main(String[] args) {
        int swapped[] = swapNoTemp(10,5);
        System.out.println(swapped[0]+", "+ swapped[1]);
    }
}