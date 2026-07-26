class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int res = 0;
        int maxOnes = 0;   // count of 1s in current window
        int ones = 0;

        for (int high = 0; high < n; high++) {
            if (nums[high] == 1) {
                ones++;
            }
            maxOnes = Math.max(maxOnes, ones);

            int len = high - low + 1;
            if (len - maxOnes > k) {
                if (nums[low] == 1) {
                    ones--;
                }
                low++;
            }

            res = Math.max(res, high - low + 1);
        }
        return res;
    }
}