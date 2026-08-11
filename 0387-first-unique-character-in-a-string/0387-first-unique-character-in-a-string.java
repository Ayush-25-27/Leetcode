class Solution {
    public int firstUniqChar(String s) {
      int n = s.length();
      Map<Character,Integer> f = new HashMap<>();
      int i;

      for(i=0; i<n; i++){
        char c = s.charAt(i);
        f.put(c, f.getOrDefault(c,0)+1);
      }  

      for(i=0; i<n; i++){
        if(f.get(s.charAt(i))==1){
            return i;
        }
      }
      return -1;
    }
}