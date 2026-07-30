class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minsum = nums[0];
        int maxsum = nums[0];
        int res = nums[0];
        int min_res = nums[0];   // Fix: track GLOBAL minimum subarray sum
        int sum = nums[0];

        for(int i = 1; i<nums.length; i++){
            sum+=nums[i];

            int v1 = nums[i];
            int v2 = minsum + nums[i];
            int v3 = maxsum + nums[i];

            maxsum = Math.max(v1,v3);
            minsum = Math.min(v1,v2);

            res = Math.max(res,maxsum);
            min_res = Math.min(min_res,minsum);  
        }

        if(res < 0){
            return res;
        }

        int last_part = sum - min_res;  
        return Math.max(res, last_part);
    }
}