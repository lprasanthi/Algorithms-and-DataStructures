// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
public class BinaryTreeMaxPathSum {
   /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        if(root == null)
            return 0;
        int left = Math.max(0, maxSum(root.left));
        int right = Math.max(0, maxSum(root.right));
        max= Math.max(max, root.val+left+right);
        return root.val + Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
} 
}