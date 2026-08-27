class Solution {

    public long fun(int[] piles, int n, int speed){
        long hi = 0;
        for(int i = 0; i<n; i++){
            hi = hi + piles[i]/speed;
            if(piles[i]%speed!=0)
                hi++;
        }
        return hi;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int res = -1;
        int low = 1;
        int high = 0;
        for(int i = 0; i<n; i++){
            high = Math.max(high,piles[i]);
        }

        while(low<=high){
            int guess = (low+high)/2;
            long hour = fun(piles,n,guess);
            if(hour>h){
                low = guess+1;
            } else{
                res = guess;
                high = guess-1;
            }
        }
        return res;
    }
}