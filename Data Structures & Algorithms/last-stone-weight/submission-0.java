class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < stones.length; i++) {
            qu.offer(stones[i]);
        }
        while(qu.size() > 1) {
            int y = qu.poll();
            int x = qu.poll();
            if(x == y) {
                continue;
            }
            qu.offer(y - x);
        }
        return qu.isEmpty() ? 0 : qu.poll();
    }
}
// 6 4 3 2 2
// 3 2 2 2
// 2 2 1
// 1