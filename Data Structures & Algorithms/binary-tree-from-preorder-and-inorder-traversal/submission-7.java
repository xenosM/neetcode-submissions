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
    // Map<Integer,Integer> preMap = new HashMap<>();
    int curr=0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);   
        }
        return DFS(preorder,0, inorder.length - 1);
    }
    // preorder = [1,2,3,4], inorder = [2,1,3,4]

    private TreeNode DFS(int[] preorder,int l,int r){
        if(l>r)return null;
        int rootVal = preorder[curr++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = DFS(preorder,l,mid-1);
        root.right = DFS(preorder,mid+1,r);
        return root;
    }




}
