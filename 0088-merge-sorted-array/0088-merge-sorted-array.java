class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     int i=0;
     int j=0;
     int id=0;
     int[] res = new int[m+n];

     while(i<m && j<n){
        if(nums1[i]< nums2[j]){
            res[id] = nums1[i];
            id++;
            i++;
        }else {
            res[id] = nums2[j];
            id++;
            j++;
        }
     }
     while(i<m){
        res[id] = nums1[i];
        id++;
        i++;
     }
     while(j<n){
        res[id] = nums2[j];
        id++;
        j++;
     } 
      for (int x=0; x < m+n; x++){
        nums1[x]=res[x];
      };  
    }
}