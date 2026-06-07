class Solution {
    List<List<Integer>> ans;
    Set<String> hs;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        hs = new HashSet<>();
        back(0, nums.length, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void back(int c, int n, int[] nums, List<Integer> l, boolean[] used) {
        if(l.size() >= n) {
            StringBuilder sb = new StringBuilder();
            for(Integer i : l) {
                sb.append(i);
            }
            if(hs.contains(sb.toString())) {
                return;
            }
            hs.add(sb.toString());
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            l.add(nums[i]);
            back(i, n, nums, l, used);
            used[i] = false;
            l.remove(l.size() - 1);
        }
    }
}