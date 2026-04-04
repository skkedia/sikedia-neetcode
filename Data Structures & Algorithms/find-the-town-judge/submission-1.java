class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] in = new int[n + 1];
        int[] ou = new int[n + 1];
        for(int[] t : trust) {
            adj.get(t[0]).add(t[1]);
            in[t[1]] += 1;
            ou[t[0]] += 1;
        }
        for(int i = 1; i <= n; i++) {
            if(in[i] == n - 1  && ou[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}