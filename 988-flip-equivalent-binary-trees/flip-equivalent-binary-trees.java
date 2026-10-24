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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return function(root1, root2);
    }

    public boolean function(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        boolean flag1 = function(root1.left, root2.left);
        boolean flag2 = function(root1.right, root2.right);

        boolean flag3 = function(root1.left, root2.right);
        boolean flag4 = function(root1.right, root2.left);

        boolean noFlip = flag1 && flag2;
        boolean flip = flag3 && flag4;

        return noFlip || flip;
    }
}