class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        back(0, nums.length, nums, new ArrayList<>());
        return ans;    
    }

    private void back(int c, int n, int[] nums, List<Integer> l) {
        for(int i = c; i < n; i++) {
            l.add(nums[i]);
            ans.add(new ArrayList<>(l));
            back(i + 1, n, nums, l);
            l.remove(l.size() - 1);
        }
    }
}
