class Solution {
    public int totalFruit(int[] fruits) {
      int k =2;
      int n = fruits.length;
      int low = 0;
      Map<Integer,Integer>freq = new HashMap<>();
      int res= -1;
      
      for(int high=0; high<n; high++){
          freq.put(fruits[high], freq.getOrDefault(fruits[high], 0)+1);
          
          while(freq.size()>k){
              int leftfruit = fruits[low];
              freq.put(leftfruit , freq.get(leftfruit)-1);
              if(freq.get(leftfruit) ==0){
                  freq.remove(leftfruit);
                 
              }
              low++;
               
          }
                  int len = high -low +1;
                  res = Math.max(len,res);
              
         }
      return res; 
    }
}