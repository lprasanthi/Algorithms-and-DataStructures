// Same as hose robber
/*
    Start with recursion, apply memorization technique and then write iteration and optimal.
    Key for iteration is to start from the end.
*/
import java.util.*;
public class Masseuse{
    private static int maxBookedHours(int[] input, int index){
        if(index >= input.length){
            return 0;
        }
        int withOne = input[index] + maxBookedHours(input, index+2);
        int withoutOne = maxBookedHours(input, index+1);
        return Math.max(withOne, withoutOne);
    }
    private static int maxBookedHoursmemo(int[] input, int index, int[] memo){
        if(index >= input.length){
            return 0;
        }
        if(memo[index] != 0){
            return memo[index];
        }
        int withOne = input[index] + maxBookedHoursmemo(input, index+2, memo);
        int withoutOne = maxBookedHoursmemo(input, index+1, memo);
        memo[index] = Math.max(withOne, withoutOne);
        return memo[index];
    }
    
    private static int maxBookedHoursIte(int[] input, int[] memo){
        for(int i=input.length-1; i>=0; i--){
            int withOne = input[i]+ memo[i+2];
            int withOutOne = memo[i+1];
            memo[i] = Math.max(withOne, withOutOne);
        }
        return memo[0];
    }
    private static int maxBookedHoursOptimal(int[] input){
        int oneAway = 0;
        int twoAway = 0;
        for(int i=input.length-1; i>=0; i--){
            int withOne = input[i]+ twoAway;
            int withOutOne = oneAway;
            int current = Math.max(withOne, withOutOne);
            twoAway = oneAway;
            oneAway = current;
        }
        return oneAway;
    }
    public static int maxBookedHours(int[] input){
        // return maxBookedHours(input,0);
        // int memo[] = new int[input.length];
        // Arrays.fill(memo,0);
        // return maxBookedHoursmemo(input,0,memo);
        // int memo[] = new int[input.length+2];
        // Arrays.fill(memo,0);
        // return maxBookedHoursIte(input,memo);
        return maxBookedHoursOptimal(input);
    }
    public static void main(String[] args) {
        int input[] = {30,15,60,75,45,15,15,45};
        System.out.println(maxBookedHours(input));
    }
}