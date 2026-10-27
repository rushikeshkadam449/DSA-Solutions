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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return true;
        }
        queue.offer(root);
        boolean nullSeen = false;
        boolean result = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                nullSeen = true;
            } else {
                if (nullSeen) {
                    result = false;
                    return result;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return result;
    }
}