class Solution {
    public int maxAbsoluteSum(int[] nums) {
    int min_end = nums[0];
    int max_end = nums[0];
    int res = Math.abs(nums[0]);

    for(int i = 1; i<nums.length; i++){
        int v1 = nums[i];
        int v2 = min_end + nums[i];
        int v3 = max_end + nums[i];

        min_end = Math.min(v1,v2);
        max_end = Math.max(v1,v3);
        res = Math.max(res,Math.max(Math.abs(min_end),Math.abs(max_end)));
    }
    return res;
    }
}