// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            
            int distance=-1;
            for(int i=nums.length-1; i>=0; i--){
                distance++;
                if(nums[i] >= distance){
                    distance = 0;
                }
            }
            return distance==0;
        }
    }
}