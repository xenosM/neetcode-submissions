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
    //we check for each node on both trees that if their left and right subtree are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if(p==null && q == null) return true; // if the node in both sides are null then its okay
      if(p == null || q== null) return false;// if only one node is  null then that means its not same
      if(p.val != q.val) return  false; 
      return isSameTree(p.left,q.left) &&  isSameTree(p.right,q.right);
    }
}
