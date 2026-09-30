import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        int n = profit.length;

        // pair of (capital, profit)
        int[][] proj = new int[n][2];
        for (int i = 0; i < n; i++) {
            proj[i][0] = capital[i];
            proj[i][1] = profit[i];
        }

        // sort by capital (then by profit, like C++ pair sort)
        Arrays.sort(proj, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                                  : Integer.compare(a[1], b[1]));

        // max-heap (C++ priority_queue<int> is a max-heap by default)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        while (k-- > 0) {
            while (idx < n) {
                if (proj[idx][0] > w) break;
                pq.add(proj[idx][1]);
                idx++;
            }

            if (pq.isEmpty()) return w;

            w = w + pq.poll(); // top() + pop()
        }
        return w;
    }
}