class Solution {
   
   public int fun(int[][]mat, int n, int m , int guess){
    int row = n-1;
    int col = 0;
    int count = 0;

    while(row>=0 && col<m){
        if(mat[row][col]<=guess){
          count = count + row+1;
            col++;
        } else{
            row--;
        }
    }
    return count;
   }


    public int kthSmallest(int[][] a, int k) {
        int n = a.length;
        int m = a[0].length;

        int low = a[0][0];
        int high = a[n-1][m-1];
        int res = -1;

        while(low<=high){
            int guess = (low+high)/2;
            int ans = fun(a,n,m,guess);
            if(ans < k) {
            low = guess + 1;
            }else {
            res = guess;
            high = guess-1;
            }
        }
        return res;
    }
    
}