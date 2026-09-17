class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max-heap: stores points, ordered by DESCENDING squared distance
        // so the "farthest" point is always at the top, ready to be evicted
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            heap.offer(point);

            // keep only the k closest points seen so far
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }
}