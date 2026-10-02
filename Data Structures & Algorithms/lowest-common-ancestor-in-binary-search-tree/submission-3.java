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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val= root.val, pval= p.val, qval = q.val;
        
        //if both the target nodes are on same side, search that side
        if(pval>val && qval>val) return lowestCommonAncestor(root.right,p,q);
        else if(pval<val && qval<val) return lowestCommonAncestor(root.left,p,q);
        //either of the target node is the root itself OR both target nodes are on seperate sides of the root
        else return root; 
        // //one of the target node is the root then that node will be the LCA
        // if(val == pval) return p;
        // if(val == qval) return q;
        // //check for split(both target nodes are on seperate sides of the root)
        // if(pval<val && qval>val || qval<val && pval>val) return root;

    }
}
