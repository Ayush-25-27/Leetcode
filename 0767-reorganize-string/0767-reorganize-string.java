class Solution {
    public String reorganizeString(String s) {
        // Step 1: frequency of each letter
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: max-heap of {char, frequency}, ordered by DESCENDING frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        StringBuilder res = new StringBuilder();

        // Step 3: greedily build the string
        while (!pq.isEmpty()) {
            int[] p = pq.poll(); // most frequent remaining char

            // safe to place p if it's the first char, or different from the last one placed
            if (res.length() == 0 || res.charAt(res.length() - 1) != (char) p[0]) {
                res.append((char) p[0]);
                p[1]--;
                if (p[1] > 0) {
                    pq.offer(p);
                }
            } else {
                // placing p now would repeat the previous char; borrow the next-most-frequent char
                if (pq.isEmpty()) {
                    return ""; // impossible to reorganize
                }
                int[] p2 = pq.poll();
                res.append((char) p2[0]);
                p2[1]--;
                if (p2[1] > 0) {
                    pq.offer(p2);
                }
                pq.offer(p); // put p back for a later turn
            }
        }

        return res.toString();
    }
}