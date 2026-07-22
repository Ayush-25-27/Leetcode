class Solution {
    public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
       long diff = Long.MAX_VALUE;
       int n = nums.length;
       int res=0;
       for(int i = 0; i<n-2;i++){
        int left = i+1;
        int right = n-1;
       
        while(left<right){
          int total = nums[i]+nums[left]+nums[right];
           int d = Math.abs(target - total);
          if(diff>d){
          diff = d;
          res = total;
        }
          if(total==target)
          return res;

          if (total<target)
          left++;
          else 
          right--;
        }

       } 
       return res;
    }
}