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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return traverse(root, res);
    }

    public List<Integer> traverse(TreeNode node, List<Integer> res) {
        if (node == null) {
            return res;
        }
        res.add(node.val);
        traverse(node.left, res);
        traverse(node.right, res);

        return res;
    }
}