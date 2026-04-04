class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> qu = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            qu.offer(nums[i]);
            if(qu.size() > k) {
                qu.poll();
            }
        }
        return qu.poll();
    }
}
