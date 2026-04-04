class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> qu = new PriorityQueue<>(
            (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points) {
            qu.offer(point);
            if(qu.size() > k) {
                qu.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while(!qu.isEmpty()) {
            int[] point = qu.poll();
            ans[i][0] = point[0];
            ans[i][1] = point[1];
            i++;
        }
        return ans;
    }
}
