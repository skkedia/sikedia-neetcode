class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        
        Queue<Integer> qu = new PriorityQueue<>((a, b) -> 
            Math.abs(a - x) == Math.abs(b - x) ? Integer.compare(a, b) : Math.abs(a - x) - Math.abs(b - x));

        for(int i : arr) {
            qu.offer(i);
        }

        while(k > 0) {
            ans.add(qu.poll());
            k--;
        }
        Collections.sort(ans);
        return ans;
    }
}