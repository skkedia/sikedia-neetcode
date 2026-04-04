class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            return Collections.singletonList(0);
        }
        List<List<Integer>> adj = new ArrayList<>();
        int[] in = new int[n];
        Queue<Integer> qu = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adj.get(x).add(y);
            adj.get(y).add(x);
            in[x]+=1;
            in[y]+=1;
        }

        for(int i = 0; i < in.length; i++) {
            if(in[i] == 1) {
                qu.offer(i);
            }
        }

        int rem = n;

        while(rem > 2) {
            int size = qu.size();
            rem = rem - size;
            for(int i = 0; i < size; i++) {
                int cur = qu.poll();
                for(int z : adj.get(cur)) {
                    in[z] -= 1;
                    if(in[z] == 1) {
                        qu.offer(z);
                    }
                }
            }
        }
        while(!qu.isEmpty()) {
            result.add(qu.poll());
        }
        return result;
    }
}