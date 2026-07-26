class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0;
        int res = -1;
        int maxfreq = 0;
        Map<Character,Integer> f = new HashMap<>();

        for(int high = 0; high<n; high++){
            char c = s.charAt(high);
            f.put(c, f.getOrDefault(c,0)+1);
            int len = high - low + 1;
            maxfreq = Math.max(maxfreq, f.get(c));

            if(len - maxfreq > k){
            char leftchar = s.charAt(low);
            f.put(leftchar, f.get(leftchar)-1);
            low++;
            }
          len = high - low +1 ;
          res = Math.max(res,len);

        }        
        return res;
    }
}