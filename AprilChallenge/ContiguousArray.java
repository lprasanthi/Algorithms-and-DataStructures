// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3298/
public class ContiguousArray {
    class Solution {
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, -1);
            int count = 0;
            int max=0;
            for(int i=0; i<nums.length; i++){
                count = count + (nums[i] == 0 ? 1 : -1);
                if(map.containsKey(count)){
                    int length = i- map.get(count);
                    max = length > max ? length : max;
                }else{
                    map.put(count, i);
                }
            }
            return max;
        }
    }
}