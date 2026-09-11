
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // 2. Min Heap: stores {number, frequency}
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        // 3. Add each pair to the heap
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            heap.offer(new int[]{entry.getKey(), entry.getValue()});

            // 4. Keep only k most frequent elements
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 5. Store the answer
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll()[0];
        }

        return ans;
    }
}
