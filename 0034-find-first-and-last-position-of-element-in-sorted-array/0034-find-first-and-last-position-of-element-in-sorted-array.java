class Solution {
    public int firstposition(int []nums, int target){
                  int n = nums.length;
        int low = 0 , high =n-1;
        int res = -1;

        while(low<=high){
            int guess =(low+high)/2;

            if(nums[guess]<target){
                low= guess+1;
            }
            else if(nums[guess]>target){
                high = guess-1;
            }
            else{
                res = guess;
                high = guess-1;
            }
        } 
        return res;
    }

        public int lastposition(int []nums, int target){
        int n = nums.length;
        int low = 0 , high =n-1;
        int res = -1;

        while(low<=high){
            int guess =(low+high)/2;

            if(nums[guess]<target){
                low= guess+1;
            }
            else if(nums[guess]>target){
                high = guess-1;
            }
            else{
                res = guess;
                low = guess+1;
            }
        } 
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstposition(nums,target);
        int last = lastposition(nums,target);
        return new int[]{first,last};
    }
}