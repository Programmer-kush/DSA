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
    public int solve(TreeNode root,int max){
        if(root==null) return 0;
        if(root.val >= max){
            max=root.val;
            return 1+solve(root.left,max) + solve(root.right,max);
        }
        return solve(root.left,max) + solve(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        return solve(root,-(int)1e8);
    }
}