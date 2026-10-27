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
    TreeNode prev = null;
    boolean result = true;

    public boolean isValidBST(TreeNode root) {
        function(root);
        return result;
    }

    public void function(TreeNode root) {
        if (root == null) {
            return;
        }
        function(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (root.val <= prev.val) {
                result = false;
            }
            prev = root;
        }

        function(root.right);
    }
}