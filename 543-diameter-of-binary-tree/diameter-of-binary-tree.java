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
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        function(root);
        return result;
    }

    public int function(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = function(root.left);
        int right = function(root.right);

        int sum = left + right;
        result = Math.max(result, sum);

        return 1 + Math.max(left, right);
    }
}