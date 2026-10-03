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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return result;
        q.add(root); // add root as the first value

        // Each iteration represents a level of the tree
        while (!q.isEmpty()) {
            // for each of node in a level, the nodes in the subsequent level will be their children
            // We do decremental loop here as q.size() increases with each iteration
            TreeNode rightSide = null;
            for (int i = q.size(); i > 0; i--) { 
                TreeNode popped = q.poll();
                if (popped != null) {
                    rightSide = popped;
                    q.add(popped.left);
                    q.add(popped.right);
                }
            }
            if (rightSide != null) {
                result.add(rightSide.val);
            }
        }
        return result;
    }
}
