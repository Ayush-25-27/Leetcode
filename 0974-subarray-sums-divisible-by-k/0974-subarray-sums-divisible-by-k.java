class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCount = new int[k];
        remainderCount[0] = 1;   // empty prefix has remainder 0, occurs once

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;


            int rem = ((sum % k) + k) % k;

            count += remainderCount[rem];
            remainderCount[rem]++;
        }

        return count;
    }
}
