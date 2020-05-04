public class ContinuousLargestSum{
    public static int getMaxSum(int[] input){
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<input.length;i++){
            sum = sum+input[i];
            if(sum > max){
                max = sum;
            }else if(sum < 0){
                sum =0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int input[] = {2,-8,3,-2,4,-10};
        System.out.println(getMaxSum(input));
    }
}