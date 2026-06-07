class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        back(0, nums.length, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private void back(int c, int n, int[] nums, List<Integer> l, boolean[] used) {
        if(l.size() == n) {
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(used[i]) {
                continue;
            }
            l.add(nums[i]);
            used[i] = true;
            back(i + 1, n, nums, l, used);
            l.remove(l.size() - 1);
            used[i] = false;
        }
        
    }
}
