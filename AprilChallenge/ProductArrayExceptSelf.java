// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
public class ProductArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int prev_mul=1;
            int[] result = new int[nums.length];
            for(int i=0; i<nums.length; i++){
                result[i] = prev_mul;
                prev_mul = prev_mul*nums[i];
            }
            prev_mul=1;
            for(int i=nums.length-1; i>=0; i--){
                result[i] = result[i]*prev_mul;
                prev_mul = prev_mul*nums[i];
            }
            return result;
        }
    }
}