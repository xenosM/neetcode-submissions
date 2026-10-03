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
        if(root == null) return result;
        q.add(root);//add root as the first value

        //Each iteration represents a level of the tree
        while(!q.isEmpty()){
            // for each of node in a level, the nodes in the subsequent level will be their children
            // We do decremental loop here as q.size() increases with each iteration
            TreeNode popped = null ;
            for(int i = q.size(); i>0 ; i-- ){//0
                if(q.peek() == null){
                    q.poll();
                    continue;
                }
                popped = q.poll();
                q.add(popped.left);
                q.add(popped.right);
            }
            if(popped != null){
            result.add(popped.val);

            }
        }
        return result;
    }
}
