/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < p.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return function(root, p, q);
    }

    public TreeNode function(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root.val >= p.val && root.val <= q.val) {
            return root;
        } else if (root.val < p.val) {
            return function(root.right, p, q);
        } else {
            return function(root.left, p, q);
        }
    }
}