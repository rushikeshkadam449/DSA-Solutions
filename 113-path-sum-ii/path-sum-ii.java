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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        function(root, targetSum, 0, res, temp);
        return res;
    }

    public void function(TreeNode root, int targetSum, int currentSum, List<List<Integer>> res, List<Integer> temp) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                res.add((new ArrayList<>(temp)));
            }
            // temp.clear();
            temp.remove(temp.size() - 1);
            return;
        }

        function(root.left, targetSum, currentSum, res, temp);
        function(root.right, targetSum, currentSum, res, temp);
        temp.remove(temp.size() - 1);

    }
}