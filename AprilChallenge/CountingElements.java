// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
public class CountingElements {
    public int countElements(int[] arr) {
        int memo[] = new int[1002];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            memo[arr[i]]++;
        }
        for(int i=0; i<arr.length; i++){
            if(memo[arr[i]+1] > 0){
                count++;
            }
        }
        return count;
    }
}