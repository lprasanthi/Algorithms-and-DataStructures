// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max=nums[0], sum=0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            max= Math.max(max,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}