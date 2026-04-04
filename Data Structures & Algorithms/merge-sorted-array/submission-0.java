class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int z = m + n - 1;

        while(i >= 0 && j >= 0) {
            int x = nums1[i];
            int y = nums2[j];

            if(nums1[i] > nums2[j]) {
                nums1[z] = nums1[i];
                i--;
            } else {
                nums1[z] = nums2[j];
                j--;
            }
            z--;
        }

        while(j >= 0) {
            nums1[z--] = nums2[j--];
        }

    }
}