// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3293/
public class DiameterBinaryTree {
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
    int max = 0;
    private int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int path = left+right;
        max = Math.max(max, path);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
}
}