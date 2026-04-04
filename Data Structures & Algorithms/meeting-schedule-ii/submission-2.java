/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) {
            return 0;
        }
        intervals.sort((a, b) -> a.start - b.start);
        Queue<Interval> qu = new PriorityQueue<>((a, b) -> a.end - b.end);
        for(int i = 0; i < intervals.size(); i++) {
            if(!qu.isEmpty() && qu.peek().end <= intervals.get(i).start) {
                qu.poll();
            }
            qu.offer(intervals.get(i));
        }
        return qu.size();
    }
}
