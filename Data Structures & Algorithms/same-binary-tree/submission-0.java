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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pq = new LinkedList<>();
        Queue<TreeNode> qq = new LinkedList<>();
        pq.offer(p);
        qq.offer(q);

        while(!pq.isEmpty() && !qq.isEmpty()) {
            for(int i = qq.size(); i > 0; i--) {
                TreeNode f = pq.poll();
                TreeNode s = qq.poll();
                if(f == null && s == null) {
                    continue;   
                }
                if(f == null || s == null || f.val != s.val) {
                    return false;
                }

                pq.offer(f.left);
                pq.offer(f.right);
                qq.offer(s.left);
                qq.offer(s.right);
            }
        }
        return true;
    }
}
