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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);   
        return isBalanced;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int l = this.height(root.left);
        int r = this.height(root.right);
        if (Math.abs(l - r) > 1)
            isBalanced = false;
        return Math.max(l, r)+1;
    }
}
