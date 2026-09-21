import java.util.*;

class Pair {
    int first;   // distance from x
    int second;  // element value

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Min heap on first (distance), then min on second (value)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return a.first - b.first;
                return a.second - b.second;
            }
        );

        for (int ele : arr) {
            pq.offer(new Pair(Math.abs(x - ele), ele));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll().second);
        }

        Collections.sort(ans);
        return ans;
    }
}