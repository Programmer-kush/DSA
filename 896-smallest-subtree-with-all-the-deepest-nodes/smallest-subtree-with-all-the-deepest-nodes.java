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
     public class pair{
        int ht;
        TreeNode node;

        pair(int ht,TreeNode node){
            this.ht=ht;
            this.node=node;
        }
    }
    public pair solve(TreeNode root){

        if(root==null){
            return new pair(0,null);
        }
        
      
        pair left=solve(root.left);
        pair right=solve(root.right);

      

        if(left.ht > right.ht){
            left.ht++;
            return left;
        }
        else if(right.ht > left.ht){
            right.ht++;
            return right;
        }
        return new pair(left.ht + 1,root);

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        pair ans=solve(root);
        return ans.node;
    }
}