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
    boolean result = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        function(root, targetSum, 0);
        return result;
    }

    public void function(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum += root.val;
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                result = true;

            }
            return;
        }
        function(root.left, targetSum, currentSum);
        function(root.right, targetSum, currentSum);
    }
}