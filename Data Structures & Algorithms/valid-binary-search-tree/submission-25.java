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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return true;
        //maximum and minimum value a node is allowed to be based on its ancestors
        if (min != null && node.val <= min)
            return false;
        if (max != null && node.val >= max)
            return false;
        /*
        ->Edge cases: the left mode path will always have a null maximum and the right most will
        have a null minimum
        ->Its only the middle paths whose max and min value both keep on changing
        */
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
