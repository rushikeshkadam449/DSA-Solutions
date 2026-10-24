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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return function(root, subRoot);
    }

    public boolean function(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val && function1(root, subRoot)) {
            return true;
        }
        boolean flag1 = function(root.left, subRoot);
        boolean flag2 = function(root.right, subRoot);

        return flag1 || flag2;

    }

    public boolean function1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        boolean flag1 = function1(p.left, q.left);
        boolean flag2 = function1(p.right, q.right);

        return flag1 && flag2;

    }
}