class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        // mergSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int ele = nums[right];
        int pi = left + (int)(Math.random() % (right - left + 1));
        
        for(int i = left; i < right; i++) {
            if(nums[i] <= ele) {
                int temp = nums[i];
                nums[i] = nums[pi];
                nums[pi] = temp;
                pi++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[pi];
        nums[pi] = temp;
        return pi;
    }

    private void mergSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergSort(nums, left, mid);
        mergSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l1 = new int[n1];
        int[] r1 = new int[n2];
        int k = left;
        for(int i = 0; i < n1; i++) {
            l1[i] = nums[k++];
        }
        
        for(int i = 0; i < n2; i++) {
            r1[i] = nums[k++];
        }

        int i = 0;
        int j = 0;
        k = left;
        while(i < n1 && j < n2) {
            if(l1[i] <= r1[j]) {
                nums[k++] = l1[i++];
            } else {
                nums[k++] = r1[j++];
            }
        }
        while(i < n1) {
            nums[k++] = l1[i++];
        }
        while(j < n2) {
            nums[k++] = r1[j++];
        }
    }
}