class Solution {
    public int maximumSum(int[] arr) {
          int no_delete = arr[0];
        int one_delete = -1;
        int res = arr[0];

        for(int i = 1; i<arr.length; i++){
            int previous_no_delete = no_delete;
            int previous_one_delete = one_delete;

            no_delete = Math.max(no_delete + arr[i],arr[i]);
            
            int v2;
            if(previous_one_delete==-1){
                v2 = arr[i];
            } else {
                v2 = previous_one_delete + arr[i];
            }
        one_delete = Math.max(v2,previous_no_delete);
        res = Math.max(res,Math.max(no_delete,one_delete));
        }
        return res;  
    }
}