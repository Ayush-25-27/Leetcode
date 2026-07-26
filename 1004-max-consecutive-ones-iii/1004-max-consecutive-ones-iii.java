class Solution {
    public int longestOnes(int[] nums, int k) {
     int n = nums.length;
     int low = 0;
     int res = -1;
     Map<Integer,Integer> f = new HashMap<>();
    int maxfreq = 0;

    for(int high = 0; high < n ; high++){
        int H = nums[high];
        f.put(H, f.getOrDefault(H,0)+1);
        int len = high - low +1;
        if(H == 1){
        maxfreq = Math.max(maxfreq, f.get(H));
        }
        
        if(len - maxfreq > k ){
            int leftN= nums[low];
            f.put(leftN, f.get(leftN)-1);
            low++;
        }
        len = high - low +1;
        res = Math.max(res,len);  

    }
  return res;

    }
}