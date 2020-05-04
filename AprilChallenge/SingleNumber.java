//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
class Solution {
    public int singleNumber(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum = sum ^ nums[i];
        }
        return sum;
    }
}