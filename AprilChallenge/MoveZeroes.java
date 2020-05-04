// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3286/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[start] = nums[i];
                start++;
            }
        }
        while(start<nums.length){
            nums[start] = 0;
            start++;
        }
    }
}