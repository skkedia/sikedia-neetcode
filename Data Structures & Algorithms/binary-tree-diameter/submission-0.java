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
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        getDia(root, 1);
        return max;
    }

    private int getDia(TreeNode node, int dep) {
        if(node == null) {
            return 0;
        }
        int left = getDia(node.left, dep + 1);
        int right = getDia(node.right, dep + 1);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
