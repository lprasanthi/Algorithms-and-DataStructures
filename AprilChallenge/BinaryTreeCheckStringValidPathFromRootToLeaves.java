// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
public class BinaryTreeCheckStringValidPathFromRootToLeaves {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr, int start, int end){
        if(root==null || start>end)
            return false;
        if(root.val != arr[start])
            return false;
        if(root.left == null && root.right == null && start==end)
            return true;
        return isValidSequence(root.left, arr, start+1, end) || isValidSequence(root.right, arr, start+1, end);
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, arr, 0,arr.length-1);
    }
}
}