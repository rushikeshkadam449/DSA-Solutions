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
    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;

        // Approach 2
        // List<Integer> ls = new ArrayList<>();
        // function(root, k, ls);
        // return ls.get(k - 1);
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inOrder(root.right, k);
    }

    // Approach 2
    // public void function(TreeNode root, int k, List<Integer> ls) {
    //     if (root == null || ls.size() == k) {
    //         return;
    //     }
    //     function(root.left, k, ls);
    //     ls.add(root.val);
    //     function(root.right, k, ls);
    // }
}