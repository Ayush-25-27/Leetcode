class Solution {
    public int arrangeCoins(int n) {
        long low = 0, high = n;
        long res = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long coinsNeeded = mid * (mid + 1) / 2;

            if (coinsNeeded <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return (int) res;
    }
}