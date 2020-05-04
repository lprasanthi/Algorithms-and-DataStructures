// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3304/
public class SearchRotatedSorted {
    class Solution {
        public int search(int[] nums, int low, int high, int target){
            int mid = (low+high)/2;
            if(low>high)
                return -1;
            if(nums[mid] == target)
                return mid;
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target < nums[mid])
                    return search(nums,low,mid-1,target);
                return search(nums,mid+1,high,target);
            }
            if(target>nums[mid] && target<=nums[high])
                return search(nums,mid+1,high,target);
            return search(nums,low,mid-1,target);
        }
        public int search(int[] nums, int target) {
            return search(nums, 0, nums.length-1, target);
        }
    }
}