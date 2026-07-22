class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       int[] a = nums;
        int n = a.length;
        Arrays.sort(a);
       List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-2; i++){
            if(i>0 && a[i]==a[i-1])
             continue;
            int left = i+1;
            int right = n-1;
            int sum = -a[i];
        while(left<right){
            int s = a[left] + a[right];
            if(s==sum){
              res.add(Arrays.asList(a[i], a[left], a[right]));
             left++;
             right--;

            while(left<n && a[left]==a[left-1])
                left++;
    
            while(right>0 && a[right]==a[right+1])
                right--;
            
            }else if (s<sum){
                left++;
            }else{
                right--;
            }
        }
        }    
          return res;
        
    }
}