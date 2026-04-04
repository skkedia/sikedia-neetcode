class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        Queue<Integer> free = new PriorityQueue<>();
        Queue<long[]> used = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1])
                                                    : Long.compare(a[0], b[0]));
        int[] book = new int[n];

        for(int i = 0; i < n; i++) {
            free.offer(i);
        }
        
        for(int i = 0; i < meetings.length; i++) {
            long start = meetings[i][0];
            long end = meetings[i][1];
            while(!used.isEmpty() && used.peek()[0] <= start) {
                int room = (int) used.poll()[1];
                free.offer(room);
            }
            if(free.isEmpty()) {
                long[] cur = used.poll();
                int room = (int) cur[1];
                end = cur[0] + (end - start);
                free.offer(room);
            }
            int room = free.poll();
            used.offer(new long[]{end, room});
            book[room]++;
        }
        int max = -1;
        int idx = -1;
        for(int i = 0; i < book.length; i++) {
            if(book[i] > max) {
                max = book[i];
                idx = i;
            }
        }
        return idx;
    }
}