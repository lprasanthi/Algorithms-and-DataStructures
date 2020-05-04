// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
public class BSTFromPreorder {
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
    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if(start>=end)
            return null;
        TreeNode root = new TreeNode(preorder[start]);
        int i=start+1;
        while(i<end && preorder[i] < preorder[start]){
            i++;
        }
        root.left = bstFromPreorder(preorder, start+1, i);
        root.right = bstFromPreorder(preorder, i, end);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length);
    }
} 
}