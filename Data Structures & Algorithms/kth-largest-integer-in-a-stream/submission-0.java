class KthLargest {
    private Queue<Integer> qu;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        qu = new PriorityQueue<>();
        for(int i : nums) {
            qu.offer(i);
            if(qu.size() > k) {
                qu.poll();
            }
        }
    }
    
    public int add(int i) {
        qu.offer(i);
        if(qu.size() > k) {
            qu.poll();
        }
        return qu.peek();
    }
}
