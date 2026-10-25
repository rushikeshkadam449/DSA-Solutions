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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        function(root, k, ls);
        return ls.get(k - 1);
    }

    public void function(TreeNode root, int k, List<Integer> ls) {
        if (root == null || ls.size() == k) {
            return;
        }
        function(root.left, k, ls);
        ls.add(root.val);
        function(root.right, k, ls);
    }
}