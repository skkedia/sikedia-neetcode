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
    int max = 0;

    public int maxDepth(TreeNode root) {
        max = 0;
        maxx(root, 1);
        return max;
    }

    private void maxx(TreeNode node, int dep) {
        if(node == null) {
            return;
        }
        max = Math.max(max, dep);
        maxx(node.left, dep + 1);
        maxx(node.right, dep + 1);
    }
}
