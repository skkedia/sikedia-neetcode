class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int hig = 0;
        for(int i : weights) {
            low = Math.max(i, low);
            hig += i;
        }

        while(low < hig) {
            int mid = low + (hig - low) / 2;
            if(canShip(mid, days, weights)) {
                hig = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canShip(int cap, int days, int[] w) {
        int cur = 0;
        int d = 1;
        for(int i = 0; i < w.length; i++) {
            cur += w[i];
            if(cur > cap) {
                d++;
                cur = w[i];
            }
            if(d > days) {
                return false;
            }
        }
        return d <= days ? true : false;
    }
}