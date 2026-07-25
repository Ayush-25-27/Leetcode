class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       int low = 0;
       int res = 0;
       Map<Character,Integer> f = new HashMap<>();

       for(int high = 0; high<n; high++){
           char c = s.charAt(high);
           f.put(c,f.getOrDefault(c,0)+1);
           int k = high - low +1;

           while(f.size()<k){
            char leftchar = s.charAt(low);
            f.put(leftchar, f.get(leftchar)-1);
            if(f.get(leftchar)==0){
                f.remove(leftchar);
            }
            low++;
            k = high - low +1; 
           }

           int len = high-low+1;
           res = Math.max(res,len);
       } 
       return res;
    }
}