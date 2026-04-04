class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < intervals.length; i++) {
            if(!mergedIntervals.isEmpty() && mergedIntervals.get(mergedIntervals.size() - 1)[1] >= intervals[i][0]) {
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math.max(
                    mergedIntervals.get(mergedIntervals.size() - 1)[1],
                    intervals[i][1]);
            } else {
                mergedIntervals.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        int[][] ans = new int[mergedIntervals.size()][2];
        for(int i = 0; i < ans.length; i++) {
            ans[i][0] = mergedIntervals.get(i)[0];
            ans[i][1] = mergedIntervals.get(i)[1];
        }
        return ans;
    }
}
