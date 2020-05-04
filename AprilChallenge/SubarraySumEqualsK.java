// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3307/
public class SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {    
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int sum = 0,result=0;
            map.put(0,1);
            for(int i=0; i<nums.length;i++){
                sum=sum+nums[i];   
                result = result + map.getOrDefault(sum-k, 0);
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
            return result;
        }
    }
}