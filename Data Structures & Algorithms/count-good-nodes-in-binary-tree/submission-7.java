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
    int res = 0;
    public int goodNodes(TreeNode root) {
        isGoodNode(Integer.MIN_VALUE,root);
        return res;
    }
    public void isGoodNode(int max,TreeNode node){
        if(node == null) return;
        if(node.val >= max) res++;
        max= Math.max(max,node.val);
        isGoodNode(max,node.left);
        isGoodNode(max,node.right);
    }
}
